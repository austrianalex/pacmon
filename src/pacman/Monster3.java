/**
 * File: Monster3.java
 * Initial Creation: May 28, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;

/**
 * Yellow smart monster.
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class Monster3 extends Monster1 {
	/**
	 * @param x
	 * @param y
	 * @param s
	 * @param c
	 */
	Monster3(int x, int y, int s, PacCanvas c){
		super(5);
		color = Color.YELLOW;
		square = s;
		curDir = 'X';
		curPos = new Point(x, y);
		relPos = new Point(x*s, y*s);
		design = new java.awt.geom.Ellipse2D.Double(curPos.x*square, curPos.y*square, square, square);
		canvas = c;
	}
	/**
	 * @see pacman.Monster1#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == animate)
			animate();
	}
	/**
	 * @see pacman.Monster1#move()
	 */
	public void move(){
		Creature player = canvas.findPlayer();
		boolean moved = false;// = moveCreature(curDir);
		if (Math.abs(curPos.x - player.curPos.x) <= 5 && Math.abs(curPos.y - player.curPos.y) <= 5){
			int rand = (int)(2.0*Math.random())+1;
			if (rand == 1)
				moved = curPos.x > player.curPos.x ? moveCreature('W') : moveCreature('E');
			else if (rand == 2 || !moved){
				moved = curPos.y > player.curPos.y ? moveCreature('N') : moveCreature('S');
				if (!moved)// give it a chance for rand 1
					moved = curPos.x > player.curPos.x ? moveCreature('W') : moveCreature('E');
			}
		}
		else if (!moved) // if "smart" didn't work, then be dumb
			super.move();
	}
}
