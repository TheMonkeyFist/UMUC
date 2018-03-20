/* P2GUI.java
 * Author: Shawn Kelly
 * February 4, 2018
 * Creates GUI for post-fix expression evaluator
*/
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class P2GUI extends JFrame implements ActionListener {

	//Private variables for P2GUI
	private JTextField  userInput;
	private JTextField output;
	private JLabel inputLbl;
	private JLabel outputLbl;
	private JPanel inputPnl;
	private JPanel outputPnl;
	private JButton construct;
	static private String txtFile;
	
	//Constructor for gui
	private P2GUI() {
		super("Three-Address Generator");
		inputPnl = new JPanel(new FlowLayout());
		outputPnl = new JPanel(new FlowLayout());
		setLayout(new GridLayout(2, 1));
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		construct = new JButton("Construct Tree");
		userInput = new JTextField(20);
		output = new JTextField(20);
		output.setEditable(false);
		inputLbl = new JLabel("Enter Postfix Expression:");
		outputLbl = new JLabel("Infix Expression:", SwingConstants.LEFT);
		inputPnl.add(inputLbl);
		inputPnl.add(userInput);
		inputPnl.add(construct);
		outputPnl.add(outputLbl);
		outputPnl.add(output);
		HandlerClass handler = new HandlerClass();
		construct.addActionListener(handler);
		add(inputPnl);
		add(outputPnl);
		addWindowListener(new WindowAdapterImpl());
	}
	
	//Creates button with action instructions
	private class HandlerClass implements ActionListener {
	@Override
		public void actionPerformed(ActionEvent e) {
		char[] input;
		Node root = null;
			PostToInfixTree postToIn = new PostToInfixTree();
			input = userInput.getText().replace(" ","").toCharArray();
			try {
				root = postToIn.constructTree(input);
			} catch (InvalidTokenException e1) {
			}
			output.setText(" " + root);
			txtFile = postToIn.getTxtFile();
		}
	}
	public static void main(String[] args) {
			new P2GUI().setVisible(true);
	}
//On window close creates txt file 
    
    private static class WindowAdapterImpl extends WindowAdapter {

        public WindowAdapterImpl() {
        }
      
        @Override
        public void windowClosing(WindowEvent e){
            try {
                FileWriter txt = new FileWriter("3-address_Format_Instructions.txt");
                 txt.write(txtFile);
                
                txt.close();
            } catch (IOException ex) {
                System.out.println("Can't create file path!");;
            }
        }
      
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
