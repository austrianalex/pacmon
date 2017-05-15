/**
 * File: Wall.java
 * Initial Creation: May 16, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;
import java.awt.*;
/**
 * Impassible wall
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class Wall extends Terrain{
	public Wall(int x, int y, int square){
		passable = false;
		color = Color.GRAY;
		curPos = new Point(x,y);
		design = new Rectangle( new Point(curPos.x*square,curPos.y*square),new Dimension(square,square));
		
	}
}
