/**
 * File: FileOpenAction.java
 * Initial Creation: Apr 28, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package lab4.menu;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * Class Description
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class FileOpenAction extends AbstractAction {
	/**
	 * 
	 */
	public static final long serialVersionUID = 1;
	/**
	 * 
	 */
	public FileOpenAction() {
		putValue(NAME, "Open") ; 
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_O)) ; 
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke('O', 
		    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false)) ; 
	}

	/**
	 * @param arg0
	 */
	public FileOpenAction(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public FileOpenAction(String arg0, Icon arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
