import javax.swing.JOptionPane;
/* MalformedFractionException.java
 * Author: Shawn Kelly
 * February 18, 2018
 * Throws error handler for improper fraction format
*/
public class MalformedFractionException extends Exception {
	public MalformedFractionException() {
		JOptionPane frame = new JOptionPane();
		JOptionPane.showMessageDialog(frame, "Malformed fraction");
	}
	public MalformedFractionException(String e) {
		JOptionPane frame = new JOptionPane();
		JOptionPane.showMessageDialog(frame, e);
	}
}
