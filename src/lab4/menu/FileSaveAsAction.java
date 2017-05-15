/**
 * File: FileSaveAsAction.java
 * Initial Creation: Apr 28, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package lab4.menu;

import java.awt.event.*;
import javax.swing.*;

/**
 * Class Description
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class FileSaveAsAction extends AbstractAction {
	/**
	 * 
	 */
	public static final long serialVersionUID = 1;
	/**
	 * 
	 */
	public FileSaveAsAction() {
		putValue(NAME, "Save As...") ; 
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_A)) ; 

	}

	/**
	 * @param name
	 */
	public FileSaveAsAction(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param icon
	 */
	public FileSaveAsAction(String name, Icon icon) {
		super(name, icon);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
