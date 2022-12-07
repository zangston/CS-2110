import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * <p>You have been hired to support deep sea research on the Nautilus 9. </p>
 * <p>This vessel uses an experimental system for locating deep sea creatures, a system that relies on 
 * super-sensitive microphones instead of active sonar. (As active sonar can adversely affect 
 *  sea life). This system has been hand-assembled by oceanographers, but the researchers need a CS 
 * expert to handle input from the microphones and turn this design into a useful tool. </p>
 * <p>Your job is to collect raw data streams from microphones and save them into an organized data stream
 * in a virtualized audio concentrator. </p>
 * <p>This task is not trivial - if data from one microphone is included in the feed from 
 * another microphone, research results will be unusable. Because weight, space and power 
 * consumption on your research vessel is at a premium (undersea research can be more 
 * expensive than space travel!) you can't simply connect a separate computer to each 
 * microphone to collect input. You must write code to make this work with one computer system.</p>
 * 
 * <p> The Microphone and Player class have been provided for you by the microphone manufacturer. You will not need to customize them.</p>
 *  <ul>
 *  <li>The <strong>Player</strong> class is simply a player of audio data. If you are successful at keeping the
 *  audio data in order, the data will play as tones.</li>
 *  
 *  <li>The <strong>Microphone</strong> class takes the analog data coming from the microphone and sends it in digital (16-bit wav)
 *  format to the audio concentrator. 
 *  </li>
 *  <li>You must write the <strong>AudioConcentrator</strong> class. An audio concentrator is a device that accepts multiple audio inputs.
 *  The Nautilus 9 has a single microphone mounted on each of
 *  the front, back, right, left, top and bottom sides of the submarine. The Audio concentrator must accept an
 *  input from each of these positions. The microphones have a limited amount of memory,
 *  so you must periodically copy each sample to the AudioConcentrator data structure. The AudioConcentrator class maintains a Queue data
 *  structure to store all the data, accepting samples from each microphone and adding them to the queue of data.
 *  Once a sampling sequence is complete, the Player will play the audio files before saving the data. If the data are
 *  in the correct sequence, tones will be played of a length equal to the total audio time. For example, six microphones
 *  recording one second of audio data should play back six seconds of data. If the data for samples are not being 
 *  recorded in order, you will hear static. If the samples are not being saved to the shared data structure Queue,
 *  the recording will be too short. You should hear one tone for each sample taken by each microphone. e.g., 6 microphones
 *  and 2 samples = 12 tones. (no static) </li>
 *  </ul>
 *  
 *  <p>The main method has been supplied for you.</p>
 * <p>
 * @author Your friendly CS Professors<br >
 * 10/24/2020
 *</p>
 */
public class AudioConcentrator {
	public  boolean playing = false; 
	private int numberOfSamplesToCollect;
	private int sampleSize;
	private byte[] audioDataStorage;
	private int storageHead, storageTail = 0;

	private int activeMicrophoneCount;
	private Microphone frontMicrophone;
	private Microphone rearMicrophone;
	private Microphone leftMicrophone;
	private Microphone rightMicrophone;
	private Microphone topMicrophone;
	private Microphone bottomMicrophone;

	private ReentrantLock dataLock;
	
	private Condition noMicsActive;
	
	public AudioConcentrator(int sampleSize, int intnumberOfSamplesToCollect) {
		this.sampleSize = sampleSize;
		this.numberOfSamplesToCollect = intnumberOfSamplesToCollect;
		activeMicrophoneCount = 0;
		
		dataLock = new ReentrantLock();
		
		noMicsActive = dataLock.newCondition();
		
		//All notes are shifted 2 octaves. 
		frontMicrophone = new Microphone(this, 523.25/4 ); //C Records 3 C
		rearMicrophone = new Microphone(this, 587.33/4 ); //D
		leftMicrophone = new Microphone(this, 662.25/4 ); //D#
		rightMicrophone = new Microphone(this, 659.26/4 ); //E
		topMicrophone = new Microphone(this, 783.99/4 ); //G
		bottomMicrophone = new Microphone(this, 880.00/4 ); //A

		audioDataStorage = new byte[sampleSize];

	}
/**
 * launch each microphone in a separate thread
 * 
 */
	public void startRecording() {
		Thread tm1 = new Thread(rightMicrophone);
		Thread tm2 = new Thread(leftMicrophone);
		Thread tm3 = new Thread(frontMicrophone);
		Thread tm4 = new Thread(rearMicrophone);
		Thread tm5 = new Thread(topMicrophone);
		Thread tm6 = new Thread(bottomMicrophone);
		tm1.start();
		tm2.start();
		tm3.start();
		tm4.start();
		tm5.start();
		tm6.start();
	}

	public static void main(String[] args) {
		AudioConcentrator nautilus9 = new AudioConcentrator(32000, 3);
		
		nautilus9.startRecording();
		nautilus9.playRecording();

	}
/**
 * play the recording once all the microphones have finished recording
 * Do not include any locks in this function. 
 * @throws InterruptedException 
 */
	public void playRecording() {
			Player p = new Player(getAudioDataStorage());
			Thread t1 = new Thread(p);
			t1.start();
			playing = true;
	}
/**
 * using these start and end microphone methods allows us to keep a count
 * of active microphones - this method allows a microphone to tell the 
 * AudioConcentrator that it is "going hot"
 */
	/**
	 * Add the appropriate locks. 
	 */
	public void startMicrophone() {
		
		dataLock.lock();
		try {
			activeMicrophoneCount++;
		} finally {
			dataLock.unlock();
		}
	}
/**
 * this method allows a microphone to tell the audio concentrator it is finished
 * collecting samples
 */
	/**
	 * TODO: Add the appropriate locks 
	 */
	public void endMicrophone() {
		
		dataLock.lock();
		try {
			activeMicrophoneCount--;
			noMicsActive.signalAll();
		} finally {
			dataLock.unlock();
		}		
	}


	/**
	 * Add the appropriate looks to the data store. 
	 * @param data
	 */
	public void storeData(byte[] data) {
		
		dataLock.lock();
		try {
			for (int i = 0; i < data.length; i++) {
				if (storageTail == audioDataStorage.length) {
					// we need to grow our array
					growStorage();
					
				}
				audioDataStorage[storageTail] = data[i];
				storageTail++;

			}
		} finally {
			dataLock.unlock();
		}
	}

	public void growStorage() {
		// each time we need to grow, double the size of the container
		// STUB: handle running out of space
		byte[] newAudioDataStorage = new byte[audioDataStorage.length * 2];
		for (int i = 0; i < audioDataStorage.length; i++) {
			newAudioDataStorage[i] = audioDataStorage[i];
		}
		audioDataStorage = newAudioDataStorage;

	}

	/**
	 * TODO: Add the appropriate locks to the Audio Data 
	 * @return
	 */
	public byte[] getAudioDataStorage() {
		dataLock.lock();
		try {
			while(activeMicrophoneCount > 0) {
				noMicsActive.await();
			}
			return this.audioDataStorage;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dataLock.unlock();
		}
		return audioDataStorage;
	}

	public int getHead() {
		return this.storageHead;
	}

	public int getTail() {
		return this.storageTail;
	}

	/**
	 * @return the activeMicrophoneCount
	 */
	public int getActiveMicrophoneCount() {
		return activeMicrophoneCount;
	}

	/**
	 * @param activeMicrophoneCount
	 *            the activeMicrophoneCount to set
	 */
	public void setActiveMicrophoneCount(int activeMicrophoneCount) {
		this.activeMicrophoneCount = activeMicrophoneCount;
	}
	public int getNumberOfSamplesToCollect() {
		return numberOfSamplesToCollect;
	}
	public void setNumberOfSamplesToCollect(int numberOfSamplesToCollect) {
		this.numberOfSamplesToCollect = numberOfSamplesToCollect;
	}

	/**
	 * @return the sampleSize
	 */
	public int getSampleSize() {
		return sampleSize;
	}

	/**
	 * @param sampleSize the sampleSize to set
	 */
	public void setSampleSize(int sampleSize) {
		this.sampleSize = sampleSize;
	}
	
}