package Hw1Part1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * 
 * Class Description
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class scribble2 
{
	/**
	 * 
	 * @param args
	 */
   public static void main(String[] args) 
   {
      ScribbleFrame frame = new ScribbleFrame();
      frame.setVisible(true);
   }
}
/**
 * 
 * Class Description
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
class ScribbleFrame extends JFrame
{
	/**
	 * 
	 */
	final static long serialVersionUID = 1;
   // constructor
	/**
	 * 
	 */
   public ScribbleFrame() 
   {
      setTitle("Scribble 2") ;
      setSize(400,400) ;
       
      // add the drawing surface
      getContentPane().add(new ScribbleCanvas()) ;
        
      // the window will actually disappear without this,
      // but the application wouldn't exit
      addWindowListener(
         new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                 System.exit(0);
            }
         }
      ) ; 
   }
}
/**
 * 
 * Class Description
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
class ScribbleCanvas extends JComponent // was: Canvas 
implements MouseListener, MouseMotionListener, ComponentListener 
{
	/**
	 * 
	 */
	static final long serialVersionUID = 1;
   // member vars
	/**
	 * 
	 */
	Image offscreen=null;
	/**
	 * 
	 */
   Point   m_ptLast ;
   /**
    * 
    */
   Image   m_buf = null ;
  
   // constructor
   /**
    * 
    */
   public ScribbleCanvas()
   {
      // try to create an initial image buffer?
      // Dimension size = getSize();
      // m_buf = createImage(size.width,size.height);
      
      // listen for mouse moves
      addMouseListener(this);
      addMouseMotionListener(this);   
      addComponentListener(this) ;
   }

   // MouseListener Events
   /**
    * @param e
    */
   public void mousePressed(MouseEvent e)
   {
      // remember the point
      m_ptLast = e.getPoint() ;
   }
   /**
    * 
    * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
    */
   public void mouseReleased(MouseEvent e){}
   /**
    * 
    * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
    */
   public void mouseClicked(MouseEvent e){}
   /**
    * 
    * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
    */
   public void mouseEntered(MouseEvent e){}
   /**
    * 
    * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
    */
   public void mouseExited(MouseEvent e){}

   // The MouseMotionListener event
   /**
    * @param e
    */
   public void mouseDragged(MouseEvent e)
   {
      drawTo(e.getPoint()) ;
   }
   /**
    * 
    * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
    */
   public void mouseMoved(MouseEvent e){}
   /**
    * 
    * @param p2
    */
   public void drawTo(Point p2)
   {
      Graphics g1 = getGraphics() ;
      g1.drawLine(m_ptLast.x, m_ptLast.y, p2.x, p2.y) ;

      Graphics g2 = m_buf.getGraphics() ;
      g2.drawLine(m_ptLast.x, m_ptLast.y, p2.x, p2.y) ;
        
      m_ptLast = p2 ;
   }
  /**
   * 
   * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
   */
   public void paintComponent(Graphics g)
   {
      //super.paint(g) ;
	  //Graphics g2 = offscreen.getGraphics();
      g.drawImage(m_buf,0,0,this) ;
      //g2.drawImage(offscreen, 0, 0, this);
   }
/**
 * 
 * @see java.awt.event.ComponentListener#componentResized(java.awt.event.ComponentEvent)
 */
   public void componentResized(ComponentEvent e)
   {
      Dimension size = getSize() ;
      if ((m_buf==null || m_buf.getWidth(this) != size.width 
              || m_buf.getHeight(this) != size.height) && size.height != 0) //need to add size.height != 0 to avoid errors when size is 0
      {
	      offscreen = createImage(size.width, size.height);
	      //repaint();
	      offscreen.getGraphics().drawImage(m_buf,0,0,this);
	      m_buf = createImage(size.width, size.height) ;
	      //m_buf = m_buf2;
	      //repaint();
	      m_buf.getGraphics().drawImage(offscreen, 0, 0, this);
      }
      
      
   }
/**
 * 
 * @see java.awt.event.ComponentListener#componentMoved(java.awt.event.ComponentEvent)
 */
   public void componentMoved(ComponentEvent e) {}
   /**
    * 
    * @see java.awt.event.ComponentListener#componentShown(java.awt.event.ComponentEvent)
    */
   public void componentShown(ComponentEvent e) {}
   /**
    * 
    * @see java.awt.event.ComponentListener#componentHidden(java.awt.event.ComponentEvent)
    */
   public void componentHidden(ComponentEvent e) {}
}
