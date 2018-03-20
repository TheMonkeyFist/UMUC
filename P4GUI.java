/* P4GUI.java
 * Author: Shawn Kelly
 * March 4, 2018
 * Creates GUI for imitating java command line compiler
*/

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;


public class P4GUI extends JFrame implements ActionListener{
	
	//Private variables to fill P4GUI
	private JLabel fileNameLbl;
	private JLabel classLbl;
	private JTextField inputFileTxt;
	private JTextField inputClassTxt;
	private JTextArea outputTxt;
	
	//Constructor to create GUI
	public P4GUI () {
		//Creates title to GUI
		super("Class Dependency Graph");
		
		//Initializes variables
		fileNameLbl = new JLabel("Input file name:");
		classLbl = new JLabel("Class to recompile:");
		inputFileTxt = new JTextField();
		inputClassTxt = new JTextField();
		outputTxt = new JTextArea(20, 40);
		outputTxt.setEditable(false);
		
		//Panels organization and fills panels
		JPanel inputPnl = new JPanel(new GridLayout(2,3));
		JPanel outputPnl = new JPanel();
		JPanel wholePnl = new JPanel();
		BoxLayout boxlayout = new BoxLayout(wholePnl, BoxLayout.Y_AXIS);
		wholePnl.setLayout(boxlayout);
		wholePnl.setBackground(Color.WHITE);
		outputPnl.setBackground(Color.WHITE);
		TitledBorder inputB;
		TitledBorder outputB;
		inputB  = BorderFactory.createTitledBorder("");
		outputB = BorderFactory.createTitledBorder("Recompilation Order");
		
		inputPnl.add(fileNameLbl);
		inputPnl.add(inputFileTxt);
		inputPnl.add(graphBtn);
		inputPnl.add(classLbl);
		inputPnl.add(inputClassTxt);
		inputPnl.add(orderBtn);
		inputPnl.setBorder(inputB);
		outputPnl.add(outputTxt);
		outputPnl.setBorder(outputB);
	
		
		wholePnl.add(inputPnl);
		wholePnl.add(outputPnl);
		
		add(wholePnl);
		
		graphBtn.addActionListener(this);
		orderBtn.addActionListener(this);
		setVisible(true);
	}
	
	//Handlers action button for graph Button
	private JButton graphBtn = new JButton(new AbstractAction ("Build Directed Graph") {
        @Override
        public void actionPerformed(ActionEvent e) {
          
            String fileName = inputFileTxt.getText();
            if(fileName.length()!= 0){
                boolean isbuild;
                isbuild = Graph.buildGraph(fileName);
                
                if(isbuild)
                    JOptionPane.showMessageDialog(null,"Graph Built Sucessfully");
                else
                    JOptionPane.showMessageDialog(null,"File Did Not Open");
            }else{
                JOptionPane.showMessageDialog(null,"Enter Valid File Name");
            }
        }
    });
	
	//Handlers action button for order Button
	private JButton orderBtn = new JButton(new AbstractAction("Topological Order") {

        @Override
        public void actionPerformed(ActionEvent e) {   
            outputTxt.setText(" ");
            String startClassName = inputClassTxt.getText();
           
         
            if(startClassName.length()!= 0){
                
                boolean isClass;
                isClass = Graph.matchName(startClassName);//check className
                if(isClass){
                ArrayList<String> orderOfCompile = Graph.topologicalSort(startClassName);
                
                if(!orderOfCompile.isEmpty()){
       
                    orderOfCompile.stream().forEach((className) -> {
                        outputTxt.setText(outputTxt.getText() + " " + className);
                    }); 
                }} else if(!isClass)
                    JOptionPane.showMessageDialog(null, "Enter Valid Class Name");
            }else 
                JOptionPane.showMessageDialog(null,"Enter a Class Name");
            
        }
    });
	public static void main(String[] args) {
		//implements the GUI for this project
		P4GUI finish = new P4GUI();
		finish.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finish.pack();
	}
	   @Override
	    public void actionPerformed(ActionEvent e) {
	      
	    }
}
