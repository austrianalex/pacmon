/**
 * File: Floor.java
 * Initial Creation: May 16, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.awt.*;


/**
 * Class Description
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class Floor extends Terrain{
	public Floor(int i, int j, int square){
		passable = true;
		color = Color.BLACK;
		curPos = new Point(i,j);
		design = new Rectangle(new Point(i*square,j*square),new Dimension(square,square));
	}
}
