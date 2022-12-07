import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

/**
 * The Microphone class is provided by the microphone manufacturer for 
 * super-sensitive undersea microphones installed on the Nautilus 9
 * 
 * @author Your friendly CS Professors 10/24/2020
 *
 */
public class Microphone implements Runnable {
	/**
	 * A microphone has some memory for storage, which is audioData, a byte array
	 * When it's memory is full, it must send the data to an AudioConcentrator,
	 * a device that accepts many inputs. (The class you are writing!)
	 * The numberOfSamplesToCollect instructs the microphone how many times you want it to 
	 * fill it's buffer of audioData and send it to the AudioConcentrator
	 */
	private byte[] audioData;
	private int numberOfSamplesToCollect;
	private AudioConcentrator concentrator;


	/** variables used in the construction of sound data 
	 * A Buffer is a class that provides a data structure for primitive types
	 * using these buffers, we can directly write binary data
	 */
	private ByteBuffer byteBuffer;
	private ShortBuffer shortBuffer;
	private int bytesPerSample;
	private int sampleLength;
	private float sampleRate;
	private int sampleSize;
	private int channels;
	private double frequency; 

	public Microphone(AudioConcentrator concentrator, double frequency) {
		this.sampleSize = concentrator.getSampleSize();
		audioData = new byte[sampleSize];
		this.numberOfSamplesToCollect = concentrator.getNumberOfSamplesToCollect();
		this.concentrator = concentrator;

		bytesPerSample = 4;
		sampleLength = sampleSize / bytesPerSample;
		byteBuffer = ByteBuffer.wrap(audioData);
		shortBuffer = byteBuffer.asShortBuffer();
		// generate a random starting frequency 
		this.frequency = frequency;
		System.out.println("Microphone Initialized");
	}

	public void run() {
		concentrator.startMicrophone();
		for (int i = numberOfSamplesToCollect; i >0 && !Thread.interrupted(); i--) {
			listen();				
		}
		concentrator.endMicrophone();
	}

	/**
	 * Listen in this context means to record audio data For this assignment, we are
	 * generating some tones
	 */
	public void listen() {
		for (int i = 0; i < sampleLength; i++) {
			// Calculate time-varying gain
			double gain = 16000.0 * i / (sampleSize / bytesPerSample);

			double time = i / 16000.0;
			
			// Generate data for left speaker
			double pianoKeyLeftEar = Math.sin(2 * Math.PI * frequency * time) * Math.exp(-0.0004 * 2 * Math.PI * frequency * time);
			pianoKeyLeftEar = pianoKeyLeftEar*pianoKeyLeftEar*pianoKeyLeftEar;
			shortBuffer.put((short) (gain * pianoKeyLeftEar));

			// generating a chord for the right speaker... just to make an interesting noise
			double pianoKeyRigthEar = Math.sin(2 * Math.PI * frequency*0.99 * time) * Math.exp(-0.0004 * 2 * Math.PI * frequency*0.99 * time);
			pianoKeyRigthEar = pianoKeyRigthEar * pianoKeyRigthEar *pianoKeyRigthEar;
			shortBuffer.put((short) (gain * pianoKeyRigthEar));
		}
		// copy data back to the ListeningConcentrator
		concentrator.storeData(audioData);
		shortBuffer.clear();
	}
}







