/**
 * File: PacFileFilter.java
 * Initial Creation: May 24, 2008
 * @author Alexander Chernikov
 * @license http://www.gnu.org/licenses/gpl.txt GNU Public License
 */
package pacman;

import java.io.File;

import javax.swing.filechooser.*;

/**
 * .pac file filter
 *
 * @author Alexander Chernikov <austrianalex@gmail.com>
 * @version 1.0
 */
public class PacFileFilter extends FileFilter{

	/**
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File f) {
		if (f.isDirectory())
			return true;

		String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1)
            ext = s.substring(i+1).toLowerCase();
        
	    if (ext != null)
			if (ext.equals("pac"))
			     return true;
			else 
				return false;

	    return false;
	}

	/**
	 * @see javax.swing.filechooser.FileFilter#getDescription()
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "PacMan Files";
	}

}
