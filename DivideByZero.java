/* DivideByZero.java
 * Author: Shawn Kelly
 * January 21, 2018
 * Creates the DivideByZero error handler to be thrown in case user tries to divide by zero
*/
public class DivideByZero extends Exception {
	//Prints out message for user
	public DivideByZero (String e) {
		super(e);
	}
}
