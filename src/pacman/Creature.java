/**
 * File: Creature.java
 * Initial Creation: May 10, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ListIterator;
import java.io.Serializable;


import javax.swing.*;

/**
 * Overlying Creature Class
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public abstract class Creature implements ActionListener, Serializable {
	RectangularShape design, arc;
	Color color;
	Point curPos, relPos, prevPos;
	Timer animate;
	transient PacCanvas canvas;
	char curDir, nextKeyDir;
	int square, speed, seq=0;
	public Creature(int sp){
		speed = sp;
		animate = new Timer(225/speed, this);
		animate.start();
	}
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public abstract void actionPerformed(ActionEvent e);
	/**
	 * @param x
	 * @param y
	 * @param dir
	 */
	public void moveTo(Point nextPos, char dir){
		prevPos = curPos;
		relPos = new Point(curPos.x*square, curPos.y*square);
		curPos = nextPos;
		curDir = dir;
		//animate.restart();
	}
	/**
	 * Animation
	 */
	public abstract void animate();
	/**
	 * Moving method. Based off of last stage of animate()
	 */
	public abstract void move();
	/**
	 * @param g
	 */
	public void draw(Graphics2D g){
		g.setPaint(color);
		g.fill(design);
		if (arc != null){
			g.setPaint(Color.BLACK);
			g.fill(arc);
		}
	}
	/**
	 * Move Creature
	 * @param c
	 * @param dir
	 * @return boolean moved or not
	 */
	protected boolean moveCreature(char dir){
		int x = curPos.x, y = curPos.y;
		switch (dir){
		case 'N': y--; break;
		case 'S': y++; break;
		case 'W': x--; break;
		case 'E': x++; break;
		case 'X': return false;
		}
		Point nextPos = new Point(x,y);
   
		ListIterator<Terrain> titerator = canvas.tstorage.listIterator();
		while ( titerator.hasNext() ){
			Terrain t = titerator.next();
			if (t.curPos.x == nextPos.x && t.curPos.y == nextPos.y){
				if (t.passable){
					moveTo(nextPos, dir);
					return true;
				}
			}  
		}
		moveTo(curPos, 'X');
		return false;
	}
}
