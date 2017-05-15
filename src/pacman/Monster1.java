/**
 * File: Monster1.java
 * Initial Creation: May 20, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

/**
 * Red Dumb Slow Easy Monster
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class Monster1 extends Creature implements Serializable{
	/**
	 * @param speed
	 */
	public Monster1(int speed){
		super(speed);
	}
	/**
	 * @param x
	 * @param y
	 * @param s
	 * @param c
	 */
	public Monster1(int x, int y, int s, PacCanvas c){
		super(2);
		square = s;
		color = Color.RED;
		curDir = 'X';
		curPos = new Point(x, y);
		relPos = new Point(x*s, y*s);
		design = new java.awt.geom.Ellipse2D.Double(curPos.x*square, curPos.y*square, square, square);
		canvas = c;
	}
	/**
	 * @see pacman.Creature#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == animate)
			animate();
	}
	/**
	 * @see pacman.Creature#animate()
	 */
	@Override
	public void animate() {
		switch (curDir){
		case 'N': relPos.y -= square/4; break;
		case 'S': relPos.y += square/4; break;
		case 'W': relPos.x -= square/4; break;
		case 'E': relPos.x += square/4; break;
		}
		seq++;
		switch(seq){
		case 1: 
			design = new java.awt.geom.Ellipse2D.Double(relPos.x, relPos.y, square, square); 
			break;
		case 2: 
			design = new java.awt.geom.Ellipse2D.Double(relPos.x, relPos.y, square, square);
			break;
		case 3: 
			design = new java.awt.geom.Ellipse2D.Double(relPos.x, relPos.y, square, square);
			break;
		case 4: 
			seq = 0;
			design = new java.awt.geom.Ellipse2D.Double(curPos.x*square, curPos.y*square, square, square);
			move();
			break;
		}
		Player p = (Player)canvas.findPlayer();
		Rectangle player = p.design.getBounds();
		
		if (design.intersects(player))
			canvas.playerDeath(p);
		canvas.repaint();
	}
	/**
	 * @see pacman.Creature#move()
	 */
	public void move(){
		boolean moved = moveCreature(curDir);
		while (moved == false){
			switch ((int)(4.0*Math.random())+1){
			case 1:	
				moved = moveCreature('N');
				break;
			case 2:
				moved = moveCreature('S');
				break;
			case 3:
				moved = moveCreature('E');
				break;
			case 4:
				moved = moveCreature('W');
				break;
			}
		}
	}

}
