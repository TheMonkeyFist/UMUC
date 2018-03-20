/* Node.java
 * Author: Shawn Kelly
 * February 4, 2018
 * Creates a node variables for values to be evaluated
*/
public class Node {

	char ch;
	Node left, right;
	//constructor
	public Node(char item) {
		ch = item;
	left = right = null;	
	}
	@Override
	public String toString() {
		return(right == null && left == null) ? Character.toString(ch) : "("
			+left.toString()+ch+right.toString()+")"; 
	}
}
