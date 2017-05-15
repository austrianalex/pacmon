/**
 * File: PacMessage.java
 * Initial Creation: May 23, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import javax.swing.*;

import com.brunchboy.util.swing.relativelayout.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Dialogue Messages
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class PacMessage extends Dialog implements ActionListener{
	
	JButton ok;
	/**
	 * @param f
	 * @param s
	 */
	public PacMessage(PacFrame f, String s) {
		super(f,"PacMessage", true);
		setSize(500,100);
		setResizable(false);
		setFocusable(true);
		RelativeLayout lay = new RelativeLayout();
		setLayout(lay);
		
		JLabel label = new JLabel(s);
		add(label, "label");
        lay.addConstraint("label", AttributeType.TOP,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.TOP,6));
        lay.addConstraint("label", AttributeType.LEFT,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.LEFT,6));
		
		ok = new JButton("OK");
		ok.addActionListener(this);
		add(ok,"ok");
        lay.addConstraint("ok", AttributeType.BOTTOM,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.BOTTOM,-6));
        lay.addConstraint("ok", AttributeType.RIGHT,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.RIGHT,-6));
	}
	/**
	 * @param e
	 */
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == ok)
			dispose();
	}
}
