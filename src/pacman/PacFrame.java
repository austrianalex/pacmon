package pacman;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Scribble Frame
 * @version 1.0
 */
public class PacFrame extends JFrame implements ActionListener
{
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem item, go, pause, open, save;
	Dialog dlg;
	JButton button;
	PacCanvas canvas;
	JLabel status;
	/**
    * Constructor
    */
	public PacFrame(){
	   setTitle("PacMon") ;
	   // CANVAS
	   canvas = new PacCanvas(this) ;
	   
	   // MENU
	   menuBar = new JMenuBar();
  
	   menu = new JMenu("File");
	   menu.setMnemonic(KeyEvent.VK_F);
	   item = new JMenuItem(new FileNewAction(canvas));
	   menu.add(item);
	   open = new JMenuItem(new FileOpenAction(canvas));
	   menu.add(open);
	   save = new JMenuItem(new FileSaveAction(canvas));
	   menu.add(save); 
	   menu.addSeparator();
	   item = new JMenuItem("Exit", KeyEvent.VK_X);
	   item.setAccelerator( KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false) );
	   item.addActionListener(this);
	   menu.add(item);
  
	   menuBar.add(menu);
	   
	   menu = new JMenu("Game");
	   menu.setMnemonic(KeyEvent.VK_G);
	   go = new JMenuItem(new GameGoAction(canvas));
	   menu.add(go);
	   pause = new JMenuItem(new GamePauseAction(canvas));
	   menu.add(pause);
	   
	   menuBar.add(menu);
	   
	   menu = new JMenu("Help");
	   menu.setMnemonic(KeyEvent.VK_H);
	   item = new JMenuItem("About", KeyEvent.VK_A);
	   item.addActionListener(this);
	   menu.add(item);
      
	   menuBar.add(menu);
      
	   setJMenuBar(menuBar);
	   
	   //Status Bar
	   status = new JLabel();
	   setStatus(" ");
	   
	   // Start game in paused mode
	   canvas.pause();
	   
	   // create the drawing surface

	   getContentPane().add(canvas);
	   getContentPane().add(status, BorderLayout.SOUTH);

	   // the window will actually disappear without this,
	   // but the application wouldn't exit
	   addWindowListener(
			   new WindowAdapter() {
				   public void windowClosing(WindowEvent e) {
					   PacFrame.this.windowClosed();
				   }
			   }
	   ) ; 
	   
	  
      
	}
	/**
	 * @param s
	 */
	public void showMessage(String s){
		dlg = new PacMessage(this, s);
		
		dlg.pack();
		dlg.setVisible(true);
		// JOptionPane.showMessageDialog(this,s);
		//System.out.println(s);
		
	}
   /**
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   public void actionPerformed(ActionEvent e){
	   	String s = e.getActionCommand();
   		if (s.equals("About"))
   			showMessage("Created by Alex Chernikov");
   		if (s.equals("Exit"))
   			windowClosed();
   }
   /**
    * Shutdown procedure
    */
   protected void windowClosed() {
      System.exit(0);
   }
   /**
    * Status Info bar changer thingy
    * @param s
    */
   public void setStatus(String s){
	   status.setText(s);
   }

}