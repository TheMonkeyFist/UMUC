import java.io.IOException;

import javax.swing.JOptionPane;

/* InvalidTokenException.java
 * Author: Shawn Kelly
 * February 18, 2018
 * Throws error handler for incorrect tokens in user input
*/
public class InvalidTokenException extends Exception {
	public InvalidTokenException() {
		JOptionPane frame = new JOptionPane();
		JOptionPane.showMessageDialog(frame, "Enter a valid expression");
	}
	public InvalidTokenException(String e) {
		JOptionPane frame = new JOptionPane();
		JOptionPane.showMessageDialog(frame, e);
	}
}
