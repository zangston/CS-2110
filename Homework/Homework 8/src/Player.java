import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 * Player is a specialized class for playing recordings made by special deep-sea
 * microphones on the Nautilus 9
 * 
 * @author Your friendly CS Professors 10/24/2020
 *
 */
public class Player implements Runnable {
	/**
	 * This player will only use one audio format: 16-bit stereo
	 */
	private AudioFormat audioFormat = new AudioFormat(16000.0F, 16, 2, true, true);
	private AudioInputStream audioInputStream;
	private SourceDataLine sourceDataLine;
	private byte audioData[];

	/**
	 * Player will have only one constructor in which audio data is passed in the
	 * form of a byte[] array
	 * 
	 * @param audioData
	 */
	public Player(byte[] audioData) {
		this.audioData = audioData;

		System.out.println("Audio player initialized with " + audioData.length + " bytes of data.");

		try {

			InputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
			audioInputStream = new AudioInputStream(byteArrayInputStream, audioFormat,
					audioData.length / audioFormat.getFrameSize());

			/**
			 * AudioSystem is a class that allows you to access the computer's audio system
			 * AudioSystem.getLine() can throw a LineUnavailableException
			 */
			DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
			sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

		} catch (LineUnavailableException e) {
			System.out.println("Error acquiring info for audio playback");
		}
	}

	/**
	 * the run method will send the audio data to the computer's sound system
	 */
	public void run() {
		try {
			System.out.println("Playing recordings");
			sourceDataLine.open(audioFormat);
			sourceDataLine.start();

			int soundByte = 0;
			/**
			 * when the audioInputStream is empty, it returns a sentinel value of -1
			 * Note we are using this byte array to access raw binary data
			 */
			while ((soundByte = audioInputStream.read(audioData, 0, audioData.length)) != -1) {
				if (soundByte > 0) {
					sourceDataLine.write(audioData, 0, soundByte);
				}
			}
			// needed to clear out and release audio resources
			sourceDataLine.drain();
			sourceDataLine.stop();
			sourceDataLine.close();
		} catch (LineUnavailableException e) {
			System.out.println("Error loading the data line");
		} catch (IOException e) {
			System.out.println("Unknown IO Exception");
		}
	}
}
