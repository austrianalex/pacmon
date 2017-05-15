/**
 * File: Monster4.java
 * Initial Creation: May 29, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.awt.Color;
import java.awt.Point;

/**
 * Invisible slow monster
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class Monster4 extends Monster1 {
	Monster4(int x, int y, int s, PacCanvas c){
		super(3);
		color = Color.BLACK;
		square = s;
		curDir = 'X';
		curPos = new Point(x, y);
		relPos = new Point(x*s, y*s);
		design = new java.awt.geom.Ellipse2D.Double(curPos.x*square, curPos.y*square, square, square);
		canvas = c;
	}
}
