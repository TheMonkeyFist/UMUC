import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* P1GUI.java
 * Author: Shawn Kelly
 * January 21, 2018
 * Creates the GUI for inputing an infix expression and solving
*/
public class P1GUI extends JFrame implements ActionListener{

	//Private variables for P1GUI
	private JButton evaluate;
	private JTextField infixBox = new JTextField (16);
	private JTextField resultBox = new JTextField(16);
	private JLabel fill = new JLabel();
	private JLabel infix = new JLabel("Enter Infix Expression");
	private JLabel result = new JLabel("Result");
	private Panel infixPanel = new Panel(new FlowLayout());
	private Panel resultPanel = new Panel(new FlowLayout());
	private Panel evaluatePanel = new Panel(new FlowLayout());
	
	//Constructor to create P1GUI
	public P1GUI () {
			super("Infix Expression Evaluator");
			setBounds(200,600,600,200);
			
			evaluate = new JButton("Evaluate");
			infixPanel.add(infix);
			infixPanel.add(infixBox);
			resultPanel.add(result);
			resultPanel.add(resultBox);
			evaluatePanel.add(fill);
			evaluatePanel.add(evaluate);
			
			getContentPane().setLayout(new BorderLayout(5,5));
			getContentPane().add(infixPanel,BorderLayout.NORTH);
			getContentPane().add(evaluatePanel,BorderLayout.CENTER);
			getContentPane().add(resultPanel,BorderLayout.SOUTH);
			pack();
			
			HandlerClass handler = new HandlerClass();
			
			evaluate.addActionListener(handler);
	}
	//Handles all button listeners to solve to infix epression
	private class HandlerClass implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			InfixEval expression = new InfixEval(infixBox.getText());
			try {
				resultBox.setText(Integer.toString(expression.execute()));
			} catch (DivideByZero e1) {
				resultBox.setText("NULL");
				JOptionPane.showMessageDialog(null, e1);
			}
		}
	}

	public static void main(String[] args) {
		P1GUI test = new P1GUI();
		 test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 test.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
