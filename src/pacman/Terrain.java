/**
 * File: Terrain.java
 * Initial Creation: May 16, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;
import java.awt.*;
import java.io.Serializable;
/**
 * Terrain
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public abstract class Terrain implements Serializable{
	Point curPos;
	boolean passable;
	Shape design;
	Color color;
	public void draw(Graphics2D g){
		g.setPaint(color);
		g.fill(design);
	}
}
