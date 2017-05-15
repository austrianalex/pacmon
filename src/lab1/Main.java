/**
 * File: Main.java
 * Initial Creation: 05/01/2007
 * Modification Date: April 3, 2008
 * @author Alexander Chernikov
 */
package lab1;
import javax.swing.*;
/**
 * This class contains the main methods for the Main program.
 * Most of this code template was originally from java.sun.com
 *  and then modified according to my program's needs.
 * It was also used in a program I made back around this time last year.
 * @author Alexander Chernikov
 * @version 1.0
 */
public class Main
{
	
	/**
	 * Main method
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	/**
	 * Frame and window setup.
	 */
	private static void createAndShowGUI() {
        //Create and set up the window.
		
        JFrame frame = new JFrame("Lab1Frame");
        frame.setSize(250,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Swing contentPane = new Swing();
        contentPane.frame = frame;
        contentPane.setOpaque(true);
        frame.setContentPane(contentPane);
        frame.setJMenuBar(contentPane.menuBar);
        //frame.add(contentPane.timestr, BorderLayout.CENTER);
        
        //Display the window.
        //frame.pack();
        frame.setVisible(true);
	}
	
}
