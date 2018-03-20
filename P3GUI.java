/* P3GUI.java
 * Author: Shawn Kelly
 * February 18, 2018
 * Creates GUI for Binary Search Tree Sort
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
public class P3GUI extends JFrame{

	//Private variables for P3GUI
	private JTextField originalTxt;
	private JTextField sortedTxt;
	private JLabel originalLbl;
	private JLabel sortedLbl;
	private JButton performBtn;
	private JRadioButton ascending;
	private JRadioButton descending;
	private JRadioButton integer;
	private JRadioButton fraction;
	
	//constructor to create P3GUI
	public P3GUI () {
		//creates visible panels
		super("Binary Search Tree Sort");
		setLayout(new GridLayout(3,1));
		
		//initializes variables into constructor
		originalTxt = new JTextField(20);
		sortedTxt = new JTextField(20);
		originalLbl = new JLabel("Original List");
		sortedLbl = new JLabel("Sorted List");
		performBtn = new JButton("Perform Sort");
		ascending = new JRadioButton("Ascending");
		descending = new JRadioButton("Descending");
		integer = new JRadioButton("Integer");
		fraction = new JRadioButton("Fraction");
		sortedTxt.setEditable(false);
		
		//creates radio button groups so they one or the other can be selected
		//sets default radio button as well
		ButtonGroup orderGrp = new ButtonGroup();
		orderGrp.add(ascending);
		orderGrp.add(descending);
		ascending.setSelected(true);
		ButtonGroup TypeGrp = new ButtonGroup();
		TypeGrp.add(integer);
		TypeGrp.add(fraction);
		integer.setSelected(true);
		
		//holds list panel (1/3 parts of GUI)
		JPanel listPnl = new JPanel();
		GroupLayout layout = new GroupLayout(listPnl);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(
						GroupLayout.Alignment.LEADING)
				.addComponent(originalLbl)
				.addComponent(sortedLbl))
				.addGroup(layout.createParallelGroup(
						GroupLayout.Alignment.LEADING)
						.addComponent(originalTxt)
						.addComponent(sortedTxt)
						));
		  layout.setVerticalGroup(layout.createSequentialGroup()
				  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			         .addComponent(originalLbl)
			         .addComponent(originalTxt))
				  .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			         .addComponent(sortedLbl)
			         .addComponent(sortedTxt)));
		listPnl.setLayout(layout);
		
		//holds sort panel (2/3 parts of GUI)
		JPanel sortPnl = new JPanel();
		sortPnl.add(performBtn);
		
		//holds radio panel (3/3 parts of GUI)
		JPanel radioPnl = new JPanel(new GridLayout(1,2));
		JPanel orderPnl = new JPanel(new GridLayout(2,1));
		JPanel typePnl = new JPanel(new GridLayout(2,1));
		TitledBorder order1;
		TitledBorder type1;
		order1 = BorderFactory.createTitledBorder("Sort Order");
		type1 = BorderFactory.createTitledBorder("Numeric Type");
		orderPnl.setBorder(order1);
		typePnl.setBorder(type1);
		orderPnl.add(ascending);
		orderPnl.add(descending);
		typePnl.add(integer);
		typePnl.add(fraction);
		radioPnl.add(orderPnl);
		radioPnl.add(typePnl);
		
		//puts all panels into the frame
		add(listPnl);
		add(sortPnl);
		add(radioPnl);

		HandlerClass handler = new HandlerClass();
		performBtn.addActionListener(handler);
		setVisible(true);
		
	}
	
	//Creates button with action instructions
		private class HandlerClass implements ActionListener {
		@Override
			public void actionPerformed(ActionEvent e) {
			//takes user input into a string
			String text = originalTxt.getText();
			//initializes the class to perform actions with the list
			PerformSort bst = new PerformSort();
			
			//Checks whether the user is using fractions or integers
			if(fraction.isSelected()) {
				try {
				ArrayList<Fraction> rawValues = bst.getArrayListF(text);
				for(int i = 0; i < rawValues.size(); i++) {
					bst.insertF(rawValues.get(i));
				}
				bst.sortF();
			} catch(NumberFormatException e1) {
				
			}
			
				if(ascending.isSelected())
					sortedTxt.setText(bst.ascendingF());
					
				if(descending.isSelected())
					sortedTxt.setText(bst.descendingF());
			}
			//User chose integer
			if(integer.isSelected()) {
				ArrayList<Integer>rawValues = null;
			try {
				rawValues = bst.getArrayListN(text);
			
			for(int i = 0; i < rawValues.size(); i++) {
				bst.insert(rawValues.get(i));
			}
			bst.sort();
			} catch (NumberFormatException e1) {
			}
			//Checks if user wants ascending or descending inorder list
			if(ascending.isSelected())
			sortedTxt.setText(bst.ascending());
			
			if(descending.isSelected())
			sortedTxt.setText(bst.descending());
			}
		}
		}
		
	public static void main(String[] args) {
		//implements the GUI for this project
		P3GUI finish = new P3GUI();
		finish.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finish.pack();
	}

	

	
}
