/* PostToInfixTree.java
 * Author: Shawn Kelly
 * February 4, 2018
 * Handles the post-fix expression from user input
 *  and returns a in-fix expression
*/
import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.JOptionPane;

public class PostToInfixTree {
	private String txtFile;
	static private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
	static private boolean isNumber(char ch) {
		return ch >= '0' && ch <= '9';
	}
	public String getTxtFile() {
		return txtFile;
	}
	public Node constructTree(char postfix[]) throws InvalidTokenException{
		if(postfix.length == 0) {
			throw new InvalidTokenException("Empty Infix Expression!");
		} else {
		Stack<Node> st = new Stack();
		txtFile = new String();
		Node t, l, r;
		int count = 0;
		//loops thru input
		for(int i = 0; i < postfix.length;i++) {
			if(!isOperator(postfix[i]) && isNumber(postfix[i])) {
				t = new Node(postfix[i]);
				st.push(t);
			}
			else if (isOperator(postfix[i])) {
				t = new Node(postfix[i]);
			//pops two nodes
			r = st.pop();
			l = st.pop();
			//makes child nodes
			t.right = r;
			t.left = l;
			switch(postfix[i]) {
			case '+':
				txtFile += "Add ";
				break;
			case '-':
				txtFile += "Sub ";
				break;
			case '*':
				txtFile += "Mul ";
				break;
			case '/':
				txtFile += "Div ";
				if(r.toString().contentEquals("0")) {
					JOptionPane.showMessageDialog(null,  "Can't divide by 0");
				}
				break;
			}
			txtFile += "R" + count + " " ;
			count++;
			if(!r.toString().startsWith("(") && !l.toString().startsWith("(")) {
				txtFile += l + " " + r + "\n";
			}else if (r.toString().startsWith("(") && l.toString().startsWith("(")){
				txtFile += "R" + (count -3)+ " " + "R" + (count -2)  + "\n";
            }
            else if(r.toString().startsWith("(") && !l.toString().startsWith("(")){
            	txtFile += l + " " + "R" + (count -2) + "\n";
            }
            else if(!r.toString().startsWith("(") && l.toString().startsWith("(")){
            	txtFile += "R"+ (count-2)+" " + r + "\n";
            }
            st.push(t);
        }else{
        	throw new InvalidTokenException("Invalid token " + postfix[i]);
        }
		}
		txtFile += " ";
		t = st.peek();
		st.pop();
		txtFile += "Infix expression: " + t;
		txtFile += " ";
		return t; 
	}
}}
