package lab4;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

/**
 * Scribble Canvas
 * @version 1.0
 */
public class ScribbleCanvas extends JPanel 
implements MouseListener, MouseMotionListener, ActionListener
{
	/**
	 * 
	 */
	static final long serialVersionUID = 1;
	/**
	 * 
	 */
	Point m_ptFrom;
	/**
	 * 
	 */
	Point m_ptTo;
	/**
	 * 
	 */
   LinkedList<MyLine> m_lines = new LinkedList<MyLine>();
   /**
    * 
    */
   final int mywidth = 400 ;
   /**
    * 
    */
   final int myheight = 400 ;
   /**
    * 
    */
   Color color = Color.black;
   /**
    * 
    */
   int width = 1;
  
   /**
    * Constructor
    */
   public ScribbleCanvas()
   {
      setSize(mywidth, myheight) ;
      setPreferredSize(new Dimension(mywidth, myheight)) ;
      setBackground(Color.white);
      //setBorder(new LineBorder(Color.black));
      // listen for mouse moves
      addMouseListener(this);
      addMouseMotionListener(this);   
   }
   /**
    * @see java.awt.Component#setSize(int, int)
    */
   public void setSize(int x, int y){
	   if (x > mywidth)
		   x = mywidth;
	   if (y > myheight)
		   y = myheight;
	   super.setSize(x,y);
   }
   /**
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */ 
   public void actionPerformed(ActionEvent e) {}
   /**
    * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
    */
   public void mousePressed(MouseEvent e)
   {
      // remember the point
	   m_ptFrom = m_ptTo = e.getPoint();
   }
   /**
    * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
    */
   public void mouseReleased(MouseEvent e){
	   //g.setXORMode(null);
	   if (contains(m_ptTo.x,m_ptTo.y)){
		   MyLine line = new MyLine(m_ptFrom, m_ptTo, width, color);
		   line.Draw(getGraphics());
		   m_lines.add(line);
	   }
   }
   /**
    * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
    */
   public void mouseClicked(MouseEvent e){}
   /**
    * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
    */
   public void mouseEntered(MouseEvent e){}
   /**
    * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
    */
   public void mouseExited(MouseEvent e){}

   /**
    * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
    */
   public void mouseDragged(MouseEvent e)
   {
	   Point tmp = e.getPoint();
	   if (contains(tmp.x,tmp.y)){
		   Graphics g = getGraphics();
		   g.setXORMode(getBackground());
		   g.drawLine(m_ptFrom.x, m_ptFrom.y, m_ptTo.x, m_ptTo.y);
		   
		   m_ptTo = e.getPoint();
		   
		   g.drawLine(m_ptFrom.x, m_ptFrom.y, m_ptTo.x, m_ptTo.y);
	   }
      
   }
   /**
    * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
    */
   public void mouseMoved(MouseEvent e){}
   /**
    * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
    */
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g) ;
      ListIterator<MyLine> iterator = m_lines.listIterator();
      while ( iterator.hasNext() ){
    	  MyLine line = iterator.next();
    	  line.Draw(g);
      }
   }
   /**
    * Clears current window and redraws
    */
   public void clear(){
	   m_lines = new LinkedList<MyLine>();
	   repaint();
   }
   /**
    * @param w
    */
   public void setWidth(int w){
	   width = w;
   }
   /**
    * @param c
    */
   public void setColor(Color c){
	   color = c;
   }
}
