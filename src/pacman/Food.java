/**
 * File: Food.java
 * Initial Creation: May 14, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;
import java.awt.*;
import java.io.Serializable;
/**
 * Food Class
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public abstract class Food implements Serializable{
	public int points;
	protected Point curPos;
	protected Shape design;
	protected Color color;
	public void draw(Graphics2D g){
		g.setPaint(color);
		g.fill(design);
	}
}
