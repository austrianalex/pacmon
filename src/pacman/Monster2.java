/**
 * File: Moster2.java
 * Initial Creation: May 23, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.awt.*;
/**
 * Blue fast dumb monster.
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class Monster2 extends Monster1{
	/**
	 * @param x
	 * @param y
	 * @param s
	 * @param c
	 */
	Monster2(int x, int y, int s, PacCanvas c){
		super(5);
		color = Color.BLUE;
		square = s;
		curDir = 'X';
		curPos = new Point(x, y);
		relPos = new Point(x*s, y*s);
		design = new java.awt.geom.Ellipse2D.Double(curPos.x*square, curPos.y*square, square, square);
		canvas = c;
	}
}
