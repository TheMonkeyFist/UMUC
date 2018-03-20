import java.awt.*;
import java.awt.event.*;
import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.*;
/* InfixEval.java
 * Author: Shawn Kelly
 * January 21, 2018
 * Handles the infix expression and solves
*/
public class InfixEval {

	Deque<Character> operator = new ArrayDeque<Character>();
	Deque<Integer> operand = new ArrayDeque<Integer>();
	char [] infix;
	
	//Creates constructor
	public InfixEval(String express) {
		infix = express.toCharArray();
	}
	//Method called when execute button is pressed to solve expression and return solution as integer
	public int execute() throws DivideByZero {
		int i = 0;
		while(i <= infix.length - 1) {
			if(infix[i]-48 >= 0 && infix[i]-48 <= 9) {
				int time = (infix[i]-48);
				operand.push(time);
				i++;
			} else if(infix[i] == '(') {
				operator.push(infix[i]);
				i++;
			} else if(infix[i] == ')') {
				while(operator.peek() != '(') {
					operand.push(operate(operator.pop(),operand.pop(),operand.pop()));
				}
				operator.pop();
				i++;
			} else if (infix[i] == '+' ||infix[i] == '-' ||infix[i] == '*' ||infix[i] == '/' ) {
				while(operator.peek() != null && ( infix[i] == '+' || infix[i] == '-') && (operator.peek() == '*' || operator.peek() == '/')) {
					operand.push(operate(operator.pop(),operand.pop(),operand.pop()));
				}
				operator.push(infix[i]);
				i++;
			}
		}
		while(!operator.isEmpty()) {
			operand.push(operate(operator.pop(),operand.pop(),operand.pop()));
		}

		return operand.pop();
	}
	//Static method to handle the four basic operations and throw in case of division by zero
	public static int operate(char oper, int a, int b) throws DivideByZero {
			switch (oper)
			{
			case '*':
				return a * b;
			case '/':
				if (a == 0) {
					throw new DivideByZero("Cannot divide by 0");
				}
				return b / a;
			case '+':
				return a + b;
			case '-':
				return b - a;
			}
			return 0;
	}
}
