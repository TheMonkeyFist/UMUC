/* NumberFormatException.java
 * Author: Shawn Kelly
 * February 18, 2018
 * Throws error handler for incorrect tokens in user input
*/
import javax.swing.JOptionPane;

public class NumberFormatException extends Exception {
		public NumberFormatException() {
			JOptionPane frame = new JOptionPane();
			JOptionPane.showMessageDialog(frame, "Non numeric input");
		}
		public NumberFormatException(String e) {
			JOptionPane frame = new JOptionPane();
			JOptionPane.showMessageDialog(frame, e);
		}
	}