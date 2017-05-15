/**
 * File: Pill.java
 * Initial Creation: May 15, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;
import java.awt.*;
/**
 * Pill = White, 1 point
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class Pill extends Food{
	public Pill(int x, int y, int square){
		points = 1;
		design = new java.awt.geom.Ellipse2D.Double(x*square+square/2, y*square+square/2, square/5, square/5);
		curPos = new Point(x,y);
		color = Color.WHITE;
	}
}
