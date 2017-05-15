/**
 * File: FileNewAction.java
 * Initial Creation: Apr 26, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.awt.event.*;
import java.awt.*;
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
	public PacCanvas canvas;
	/**
	 * @param c
	 */
	public FileNewAction(PacCanvas c) {
		putValue(NAME, "New") ;
		putValue(SHORT_DESCRIPTION,"New");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_N)) ; 
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke('N', 
		    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false)) ;
		
		ImageIcon icon = new ImageIcon("New.gif");
		putValue(SMALL_ICON, icon);
		canvas = c;
	}


	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		canvas.newGame();

	}

}
