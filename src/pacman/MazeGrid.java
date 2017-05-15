/**
 * File: MazeGrid.java
 * Initial Creation: May 14, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;
import java.awt.*;
import java.io.Serializable;
/**
 * Construction of the maze.
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class MazeGrid implements Serializable{
	
	Dimension d;
	Rectangle r;
	Point p;
	public int grid[], height, width, square;
	
	public MazeGrid(int s, int[] g){
		square = s;
		d = new Dimension(square,square);
		p = new Point(0,0);
		grid = g;
		height = 20;
		width = 20;
	}
}
