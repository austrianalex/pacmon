/**
 * File: ColorMenuAction.java
 * Initial Creation: Apr 28, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package lab4.menu;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import lab4.ScribbleCanvas;

/**
 * Class Description
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class ColorMenuAction extends AbstractAction {
	/**
	 * 
	 */
	public static final long serialVersionUID = 1;
	/**
	 * 
	 */
	public ScribbleCanvas canvas;
	/**
	 * 
	 */
	public ColorMenuAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param color
	 */
	public ColorMenuAction(Color color) {
		putValue(NAME, color+"") ;
		putValue("COLOR", color);
		
	}
	/**
	 * @param color
	 * @param name
	 * @param c
	 */
	public ColorMenuAction(Color color, String name, ScribbleCanvas c){
		putValue(NAME, name) ;
		putValue("COLOR", color);
		canvas = c;
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Color color = (Color)getValue("COLOR");
		canvas.setColor(color);
	}

}
