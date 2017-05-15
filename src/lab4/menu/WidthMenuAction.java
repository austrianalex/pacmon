/**
 * File: WidthMenuAction.java
 * Initial Creation: Apr 28, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package lab4.menu;

import lab4.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class Description
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class WidthMenuAction extends AbstractAction {
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
	public WidthMenuAction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param width
	 * @param c
	 */
	public WidthMenuAction(int width, ScribbleCanvas c) {
		putValue(NAME, width+" pixel(s)") ;
		putValue("WIDTH", width);
		canvas = c;
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Integer width = (Integer)getValue("WIDTH");
		canvas.setWidth(width);
	}

}
