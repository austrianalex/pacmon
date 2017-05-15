package lab1;
/**
 * File: Swing.java
 * Initial Creation: May 3, 2007
 * Modification Date: April 3, 2008
 * @author Alexander Chernikov
 * @copyright (C) 2007 Alexander Chernikov
 */
import java.awt.*;
import java.awt.event.*;
//import java.io.*;
import javax.swing.*;
import java.util.Date;
/**
 * @author Alexander Chernikov
 * @version 1.2
 */
public class Swing extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000000000;
	/**
	 * 
	 */
	protected Date timestamp;
	/**
	 * 
	 */
	JFrame frame;
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
    Graphics gfx;
    /**
     * 
     */
    JLabel timestr;
    //JPopupMenu dlgbox;
//    JButton openButton, saveTable;
//    JTextArea output;
    /**
     * Window contents
     */
    public Swing() {
        super(new BorderLayout());
        //cl = this.getClass().getClassLoader();
        timestamp = new Date();
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        item = new JMenuItem("Time Stamp");
        item.addActionListener(this);
        menu.add(item);
        item = new JMenuItem("Exit", KeyEvent.VK_E);
        item.addActionListener(this);
        menu.add(item);
        
        menuBar.add(menu);
        
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        item = new JMenuItem("About", KeyEvent.VK_A);
        item.addActionListener(this);
        menu.add(item);
        
        menuBar.add(menu);
        
        //timestr = new JLabel(dateStamp+"",JLabel.CENTER);
        
    }
    /**
     * @see javax.swing.JComponent#paint(java.awt.Graphics)
     */
    public void paint(Graphics g){
    	super.paint(g);
        Font ft = new Font("SansSerif", Font.PLAIN, 18);
        Color c = new Color(255, 0, 0);
        g.setFont(ft);
        FontMetrics fm = g.getFontMetrics(g.getFont());
        
        Dimension dmain = frame.getSize();
        Insets in = frame.getInsets();
        Dimension dmenu = frame.getJMenuBar().getSize();
   
        //hello world hello swing
        g.setColor(c);
    	g.drawString("Hello", 10, (int)dmenu.getHeight());
    	c = new Color(0, 255, 0);
    	g.setColor(c);
    	g.drawString("World", (int)dmain.getWidth()-fm.stringWidth("World")-in.right*2-10,(int)dmenu.getHeight());
    	c = new Color(0, 0, 255);
    	g.setColor(c);
    	g.drawString("Hello", 10, (int)dmain.getHeight()-in.bottom-10-in.top-fm.getHeight());
    	c = new Color(255, 255, 0);
    	g.setColor(c);
    	g.drawString("Swing", (int)dmain.getWidth()-fm.stringWidth("World")-in.right*2-10, (int)dmain.getHeight()-in.bottom-10-in.top-fm.getHeight());
    	
    	//timestamp
    	g.setColor(Color.BLACK);
    	g.drawString(timestamp+"", ((int)dmain.getWidth())/2-fm.stringWidth(timestamp+"")/2, ((int)dmain.getHeight()-in.top-in.bottom)/2-fm.getHeight()/2 );
    }
    /**
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
    	String s = e.getActionCommand();
    	if (s.equals("About"))
    		onAbout();
    	else if (s.equals("Time Stamp"))
    		onTimeStamp();
    	else if (s.equals("Exit"))
    		System.exit(-1);
    }
    /**
     * Menu call for about
     */
    private void onAbout(){
    	JOptionPane.showMessageDialog(new JFrame(),
    			"++\n" +
    			"Lab 1\n" +
    			"Program Created by Alexander Chernikov\n" +
    			"++",
    			"About this program..."
    			,JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * Menu call for timestamp
     */
    private void onTimeStamp(){
    	timestamp = new Date();
    	repaint();
    }
    
}
