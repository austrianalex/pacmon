/**
 * File: Scribble.java
 * Initial Creation: Apr 21, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package lab4;

import lab4.menu.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Scribble
 * @version 1.0
 */
public class Scribble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScribbleFrame frame = new ScribbleFrame();
		frame.setVisible(true);
	}

}
/**
 * Scribble Frame
 * @version 1.0
 */
class ScribbleFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	static final long serialVersionUID = 1;
	/**
	 * 
	 */
	JMenuBar menuBar;
	/**
	 * 
	 */
	JMenu menu;
	/**
	 * 
	 */
	JMenuItem item;
	/**
	 * 
	 */
	JRadioButtonMenuItem radio;
	/**
	 * 
	 */
	ButtonGroup group;
	/**
    * Constructor
    */
   public ScribbleFrame() 
   {

      setSize(300,300) ;
      setTitle("Scribble") ;
      
      ScribbleCanvas canvas = new ScribbleCanvas() ;
      
      menuBar = new JMenuBar();
      
      menu = new JMenu("File");
      menu.setMnemonic(KeyEvent.VK_F);
      item = new JMenuItem(new FileNewAction(canvas));
      menu.add(item);
      item = new JMenuItem(new FileOpenAction());
      menu.add(item);
      item = new JMenuItem(new FileSaveAction());
      menu.add(item); 
      item = new JMenuItem(new FileSaveAsAction());
      menu.add(item);
      item = new JMenuItem("Exit", KeyEvent.VK_X);
      item.setAccelerator( KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false) );
      item.addActionListener(this);
      menu.add(item);
      
      menuBar.add(menu);
      
      menu = new JMenu("Width");
      menu.setMnemonic(KeyEvent.VK_W);
      group = new ButtonGroup();
      radio = new JRadioButtonMenuItem(new WidthMenuAction(1, canvas));
      radio.setSelected(true);
      group.add(radio);
      menu.add(radio);
      radio = new JRadioButtonMenuItem(new WidthMenuAction(4, canvas));
      group.add(radio);
      menu.add(radio);
      radio = new JRadioButtonMenuItem(new WidthMenuAction(8, canvas));
      group.add(radio);
      menu.add(radio);
      
      menuBar.add(menu);
      
      menu = new JMenu("Color");
      menu.setMnemonic(KeyEvent.VK_C);
      group = new ButtonGroup();
      radio = new JRadioButtonMenuItem(new ColorMenuAction(Color.black, "Black", canvas));
      radio.setSelected(true);
      menu.add(radio);
      group.add(radio);
      radio = new JRadioButtonMenuItem(new ColorMenuAction(Color.red, "Red", canvas));
      menu.add(radio);
      group.add(radio);
      radio = new JRadioButtonMenuItem(new ColorMenuAction(Color.green, "Green", canvas));
      menu.add(radio);
      group.add(radio);
      radio = new JRadioButtonMenuItem(new ColorMenuAction(Color.blue, "Blue", canvas));
      menu.add(radio);
      group.add(radio);
      
      menuBar.add(menu);
      
      menu = new JMenu("Help");
      menu.setMnemonic(KeyEvent.VK_H);
      item = new JMenuItem("About", KeyEvent.VK_A);
      item.addActionListener(this);
      menu.add(item);
      
      menuBar.add(menu);
      
      setJMenuBar(menuBar);
      // create the drawing surface
      
      JScrollPane scrollpane = new JScrollPane(canvas) ;

      getContentPane().add(scrollpane) ;

      // the window will actually disappear without this,
      // but the application wouldn't exit
      addWindowListener(
         new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                 ScribbleFrame.this.windowClosed();
            }
         }
      ) ; 
      
   }
   /**
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   public void actionPerformed(ActionEvent e){
	   	String s = e.getActionCommand();
   		if (s.equals("About"))
   			JOptionPane.showMessageDialog(this, "Created by Alex Chernikov");
   		if (s.equals("Exit"))
   			windowClosed();
   }
   /**
    * Shutdown procedure
    */
   protected void windowClosed() 
   {
      System.exit(0);
   }
}