import javax.swing.JOptionPane;
/* InsufficientFunds.java
 * Author: Shawn Kelly
 * November 19, 2017
 * handles all exceptions
*/
public class InsufficientFunds extends Exception {
	
	public InsufficientFunds() {
		//Exception is thrown if account balance is less than 0 
		
		JOptionPane frame = new JOptionPane();
		JOptionPane.showMessageDialog(frame, "You have insufficient funds.");
	}
	public InsufficientFunds(String e) {
		//Exception is thrown if account balance is less than 0 
		
		JOptionPane frame = new JOptionPane();
		JOptionPane.showMessageDialog(frame, "You have insufficient funds.");
	}
}
