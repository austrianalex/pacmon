/**
 * File: MyLine.java
 * Initial Creation: Apr 21, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package lab4;

import java.awt.*;

/**
 * Custome Line Object
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class MyLine {
	/**
	 * 
	 */
	public Point m_ptFrom;
	/**
	 * 
	 */
	public Point m_ptTo;
	/**
	 * 
	 */
	public int width;
	/**
	 * 
	 */
	public Color color;
	/**
	 * @param a
	 * @param b
	 * @param w
	 * @param c
	 */
	public MyLine(Point a, Point b, int w, Color c){
		m_ptFrom = a;
		m_ptTo = b;
		width = w;
		color = c;
	}
	/**
	 * Drawing method in red
	 * @param gfx
	 */
	public void Draw(Graphics gfx){
		Graphics2D g = (Graphics2D)gfx;
		g.setColor(color);
		g.setStroke(new BasicStroke(width));
		g.drawLine(m_ptFrom.x, m_ptFrom.y, m_ptTo.x, m_ptTo.y);
	}
}
