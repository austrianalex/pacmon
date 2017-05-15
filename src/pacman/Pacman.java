/**
 * File: Scribble.java
 * Initial Creation: Apr 21, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 * Scribble
 * @version 1.0
 */
public class Pacman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createAndShowGUI();
            }
        });
		//while (true){
			//testPlay("1.mp3");
			//testPlay("2.mp3");
		//}
	}
	/**
	 * 
	 */
	public static void createAndShowGUI(){
		PacFrame frame = new PacFrame();
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
	   /**
	    * @param filename
	    */
	   public static void testPlay(String filename)
	   {
		  
	     try {
	       File file = new File(filename);
	       AudioInputStream in= AudioSystem.getAudioInputStream(file);
	       AudioInputStream din = null;
	       AudioFormat baseFormat = in.getFormat();
	       AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
	                                                                                     baseFormat.getSampleRate(),
	                                                                                     16,
	                                                                                     baseFormat.getChannels(),
	                                                                                     baseFormat.getChannels() * 2,
	                                                                                     baseFormat.getSampleRate(),
	                                                                                     false);
	       din = AudioSystem.getAudioInputStream(decodedFormat, in);
	       // Play now.
	       rawplay(decodedFormat, din);
	       in.close();
	     } catch (Exception e)
	       {
	    	 System.out.print(e.getMessage());
			   e.printStackTrace();
	       }
	   }
	/**
	 * @param targetFormat
	 * @param din
	 * @throws IOException
	 * @throws LineUnavailableException
	 */
	   private static void rawplay(AudioFormat targetFormat, AudioInputStream din) throws IOException,                                                                                                LineUnavailableException
	   {
	     byte[] data = new byte[4096];
	     SourceDataLine line = getLine(targetFormat);
	     if (line != null)
	     {
	       // Start
	       line.start();
	       int nBytesRead = 0;
	       while (nBytesRead != -1)
	       {
	           nBytesRead = din.read(data, 0, data.length);
	           if (nBytesRead != -1) line.write(data, 0, nBytesRead);
	       }
	       // Stop
	       line.drain();
	       line.stop();
	       line.close();
	       din.close();
	     }
	   }
	   /**
	    * @param audioFormat
	    * @return
	    * @throws LineUnavailableException
	    */
	   private static SourceDataLine getLine(AudioFormat audioFormat) throws LineUnavailableException
	   {
	     SourceDataLine res = null;
	     DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
	     res = (SourceDataLine) AudioSystem.getLine(info);
	     res.open(audioFormat);
	     return res;
	   }

}