/**
 * File: OptionsDlg.java
 * Initial Creation: May 13, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package lab6;

import java.awt.*;
import java.awt.event.*;
import com.brunchboy.util.swing.relativelayout.*;
import javax.swing.*;

/**
 * Options Dialogue
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class OptionsDlg extends JDialog implements ActionListener, FocusListener {

	JRadioButton showTime, showString;
	JTextField text;
	JLabel fontLabel, validRangeLabel;
	JFormattedTextField font;
	JCheckBox italics, bold;
	JButton ok, cancel;
	/**
	 * @param f
	 */
	public OptionsDlg(Frame f) {
		// TODO Auto-generated constructor stub
		super(f,"Text Options", true);
		setSize(300,200);
		setResizable(false);
		
		RelativeLayout lay = new RelativeLayout();
		setLayout(lay);
        
		// Show Time
		showTime = new JRadioButton("Show time");
		add(showTime, "time");
		showTime.setSelected(true);
        lay.addConstraint("time", AttributeType.TOP,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.TOP,6));
        lay.addConstraint("time", AttributeType.LEFT,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.LEFT,6));
        
        // Show This String:
        showString = new JRadioButton("Show this string:");
        add(showString, "string");
        lay.addConstraint("string", AttributeType.TOP,	new AttributeConstraint("time",AttributeType.BOTTOM,-3));
        lay.addConstraint("string", AttributeType.LEFT,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.LEFT,6));
        
        // Text Field
        text = new JTextField("Hi Mom!");
        text.setEnabled(false);
        add(text, "text");
        lay.addConstraint("text", AttributeType.TOP,	new AttributeConstraint("string",AttributeType.BOTTOM,3));
        lay.addConstraint("text", AttributeType.LEFT,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.LEFT,6));
        lay.addConstraint("text", AttributeType.RIGHT,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.RIGHT,-6));
        
        // FontMetrics Changer Label
        fontLabel = new JLabel("Text Height (in pts):");
        add(fontLabel, "fontLabel");
        lay.addConstraint("fontLabel", AttributeType.TOP,	new AttributeConstraint("text",AttributeType.BOTTOM,6));
        lay.addConstraint("fontLabel", AttributeType.LEFT,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.LEFT,6));
        
        // FontMetrics Changer Changer mmm
        font = new JFormattedTextField(20);
        add(font, "font");
        lay.addConstraint("font", AttributeType.TOP,	new AttributeConstraint("text",AttributeType.BOTTOM,3));
        lay.addConstraint("font", AttributeType.LEFT,	new AttributeConstraint("fontLabel",AttributeType.RIGHT,6));
        lay.addConstraint("font", AttributeType.RIGHT,	new AttributeConstraint("font",AttributeType.LEFT,30));
        
        // Valid Range info
        validRangeLabel = new JLabel("(8-40)");
        add(validRangeLabel,"validRange");
        lay.addConstraint("validRange", AttributeType.TOP,	new AttributeConstraint("text",AttributeType.BOTTOM,6));
        lay.addConstraint("validRange", AttributeType.LEFT,	new AttributeConstraint("font",AttributeType.RIGHT,6));
        
        // Italics Checkbox
        italics = new JCheckBox("Italics");
        add(italics,"italics");
        lay.addConstraint("italics", AttributeType.TOP,	new AttributeConstraint("validRange",AttributeType.BOTTOM,6));
        lay.addConstraint("italics", AttributeType.LEFT,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.LEFT,6));
        
        // Bold CheckBox
        bold = new JCheckBox("Bold");
        add(bold,"bold");
        lay.addConstraint("bold", AttributeType.TOP,	new AttributeConstraint("italics",AttributeType.BOTTOM,-3));
        lay.addConstraint("bold", AttributeType.LEFT,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.LEFT,6));
        
        // OK
        ok = new JButton("Ok");
        add(ok,"ok");
        getRootPane().setDefaultButton(ok);
        lay.addConstraint("ok", AttributeType.BOTTOM,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.BOTTOM,-6));
        lay.addConstraint("ok", AttributeType.RIGHT,	new AttributeConstraint("cancel",AttributeType.LEFT,-6));
        
        // Cancel
        cancel = new JButton("Cancel");
        add(cancel,"cancel");
        lay.addConstraint("cancel", AttributeType.BOTTOM,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.BOTTOM,-6));
        lay.addConstraint("cancel", AttributeType.RIGHT,	new AttributeConstraint(DependencyManager.ROOT_NAME,AttributeType.RIGHT,-6));
        
        // Button Grouping
        ButtonGroup group = new ButtonGroup();
        group.add(showTime);
        group.add(showString);
        
        // Action Events
        showTime.setActionCommand("time");
        showString.setActionCommand("string");
        
        showTime.addActionListener(this);
        showString.addActionListener(this);
        ok.addActionListener(this);
        cancel.addActionListener(this);
        
        // Focus Events
        font.addFocusListener(this);
        
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s.equals("Ok") || s.equals("Cancel"))
			setVisible(false);
		else if (s.equals("time"))
			text.setEnabled(false);
		else if (s.equals("string"))
			text.setEnabled(true);

	}
	
	/**
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	public void focusGained(FocusEvent e){}
	/**
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
	 */
	public void focusLost(FocusEvent e){
		try{
			font.commitEdit();
		}catch (Exception exc){
			System.exit(-1);
		}
		int val = ( (Number)font.getValue() ).intValue();
		if (val > 40)
			font.setValue(40);
		else if (val < 8)
			font.setValue(8);
	}

}
