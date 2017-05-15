/**
 * File: Player.java
 * Initial Creation: May 15, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

/**
 * The Player PacMan or whatever
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class Player extends Creature implements Serializable{
	public Point startPos;
	public boolean deathHack;
	public Player(int x, int y, int s, PacCanvas c){
		super(5);
		square = s;
		color = Color.YELLOW;
		curDir = 'X';
		prevPos = curPos = startPos = new Point(x, y);
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
	 * @see pacman.Creature#moveTo(java.awt.Point, char)
	 */
	@Override
	public void moveTo(Point nextPos, char dir) {
		super.moveTo(nextPos, dir);
		canvas.eatFood(prevPos);
	}
	/**
	 * @see pacman.Creature#animate()
	 */
	public void animate(){
		double angle = 0, radius = square/(double)2; 
		switch (curDir){
		case 'N': 
			relPos.y -= square/4;
			angle = 45;
			break;
		case 'S': 
			relPos.y += square/4;
			angle = 225;
			break;
		case 'W': 
			relPos.x -= square/4;
			angle = 135;
			break;
		case 'E': 
			relPos.x += square/4; 
			angle = 315;
			break;
		}
		seq++;
		//prevDesign = design;
		switch(seq){
		case 1: 
			//color = Color.BLUE; 
			design = new java.awt.geom.Ellipse2D.Double(relPos.x, relPos.y, square, square); 
			arc = new java.awt.geom.Arc2D.Double(design.getX(), design.getY(), 2*radius, 2*radius, angle+15, 45, java.awt.geom.Arc2D.PIE);
			break;
		case 2: 
			//color = Color.RED; 
			design = new java.awt.geom.Ellipse2D.Double(relPos.x, relPos.y, square, square);
		    arc = new java.awt.geom.Arc2D.Double(design.getX(), design.getY(), 2*radius, 2*radius, angle, 90, java.awt.geom.Arc2D.PIE);
			break;
		case 3: 
			//color = Color.GREEN;
			design = new java.awt.geom.Ellipse2D.Double(relPos.x, relPos.y, square, square);
			arc = new java.awt.geom.Arc2D.Double(design.getX(), design.getY(), 2*radius, 2*radius, angle+15, 45, java.awt.geom.Arc2D.PIE);
			break;
		case 4: 
			seq = 0;
			//color = Color.YELLOW; 
			design = new java.awt.geom.Ellipse2D.Double(curPos.x*square, curPos.y*square, square, square);
			arc = null;
			move();
			break;
		}
		if (angle == 0)
			arc = null;
		canvas.repaint();
		if (deathHack)
			deathHack = false;
	}
	/**
	 * @see pacman.Creature#move()
	 */
	public void move(){
		moveCreature(nextKeyDir);
	}

}
