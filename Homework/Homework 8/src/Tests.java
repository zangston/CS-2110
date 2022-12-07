import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.junit.Test;

public class Tests {

	@Test
	public void test(){
		AudioConcentrator nautilus9 = new AudioConcentrator(300, 1);
		nautilus9.startRecording();
		nautilus9.playRecording();
		byte[] bytes = nautilus9.getAudioDataStorage();
		short[] shorts = new short[bytes.length/2];
		// to turn bytes to shorts as either big endian or little endian. 
		ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(shorts);
		Complex[] x = new Complex[shorts.length];
		//Generate Complex arary
		for(int i =0; i <shorts.length; i++) {
				x[i] = new Complex((int)shorts[i], 0);
			}
				//Complete FFT on results
			 //FFT of original data
			Complex[] fftY = FFT.dft(x);
			double total = 0;
			for (Complex y : fftY) {
				total += Math.abs(y.re()/10000);
			}
			//Time domain changes but frequeny domain stay the same
			//Check ranges seem if sum real values a with a range. 
			// Only use ranging to account for small rounding errors
			//That might occur due to system archeture. 
			 assertTrue("Error, sum is too high", total >= 30000);
			 assertTrue("Error, sum is too low",  total  <= 40000);
	
		}

}