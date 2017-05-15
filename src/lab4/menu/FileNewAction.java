/**
 * File: FileNewAction.java
 * Initial Creation: Apr 26, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package lab4.menu;

import java.awt.event.*;
import java.awt.*;
import lab4.*;
import javax.swing.*;

/**
 * Class Description
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class FileNewAction extends AbstractAction {
	/**
	 * 
	 */
	public static final long serialVersionUID = 1;
	/**
	 * 
	 */
	public ScribbleCanvas canvas;
	/**
	 * @param c
	 */
	public FileNewAction(ScribbleCanvas c) {
		putValue(NAME, "New") ; 
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_N)) ; 
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke('N', 
		    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false)) ;
		canvas = c;
	}

	/**
	 * @param arg0
	 */
	public FileNewAction(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public FileNewAction(String arg0, Icon arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		canvas.clear();

	}

}
