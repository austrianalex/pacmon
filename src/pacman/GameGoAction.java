/**
 * File: GameGoAction.java
 * Initial Creation: May 23, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

/**
 * Class Description
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class GameGoAction extends AbstractAction {
	PacCanvas canvas;
	/**
	 * 
	 */
	public GameGoAction(PacCanvas c) {
		putValue(NAME, "Go") ; 
		putValue(SHORT_DESCRIPTION,"Resume Game");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_G)) ;
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke('G', 
		    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false)) ;
		canvas = c;
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		canvas.resume();
	}

}
