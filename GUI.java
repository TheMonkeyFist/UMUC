/* GUI.java
 * Author: Shawn Kelly
 * December 16, 2017
 * Creates the GUI for the student class
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GUI extends JFrame{
	
	//create variables for GUI
	private final JTextField id = new JTextField("");
	private final JTextField name = new JTextField("");
	private final JTextField major = new JTextField("");
	private final JLabel idLabel = new JLabel("ID: ");
	private final JLabel nameLabel = new JLabel("Name: ");
	private final JLabel majorLabel = new JLabel("Major: ");
	private final JLabel chooseLabel = new JLabel("Choose Selection:  ");
	
	private final String[] actions = {"Insert", "Delete", "Find", "Update"};
	private final String[] grades = {"A", "B", "C", "D", "F"};
	private final JComboBox actionsOptions = new JComboBox(actions);
	private final JComboBox gradesOptions = new JComboBox(grades);
	
	private final JButton processRequest = new JButton("Process Request");
	HashMap map = new HashMap();
	
	//Creates constructor create GUI with variables
	public GUI() {
		setLayout(new GridLayout(1, 2));
		
		//create panels
		JPanel IOPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		JPanel gradePanel = new JPanel();
		JPanel creditPanel = new JPanel();
		IOPanel.setLayout(new BoxLayout(IOPanel, BoxLayout.PAGE_AXIS));
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
		gradePanel.setLayout(new BoxLayout(gradePanel, BoxLayout.PAGE_AXIS));
		creditPanel.setLayout(new BoxLayout(creditPanel, BoxLayout.PAGE_AXIS));
		
		//edit text boxes variables
		id.setBackground(Color.WHITE);
		id.setEditable(true);
		name.setBackground(Color.WHITE);
		name.setEditable(true);
		major.setBackground(Color.WHITE);
		
		//add elements to panels
		labelPanel.add(Box.createVerticalStrut(2));
		labelPanel.add(idLabel);
		labelPanel.add(Box.createVerticalStrut(10));
		labelPanel.add(nameLabel);
		labelPanel.add(Box.createVerticalStrut(10));
		labelPanel.add(majorLabel);
		labelPanel.add(Box.createVerticalStrut(10));
		labelPanel.add(chooseLabel);
		labelPanel.add(Box.createVerticalStrut(15));
		labelPanel.add(processRequest);
		labelPanel.add(Box.createVerticalStrut(25));
		
		   IOPanel.add(id);
           IOPanel.add(Box.createVerticalStrut(5));
           IOPanel.add(name);
           IOPanel.add(Box.createVerticalStrut(5));
           IOPanel.add(major);
           IOPanel.add(Box.createVerticalStrut(5));
           IOPanel.add(actionsOptions);
           IOPanel.add(Box.createVerticalStrut(68));
           actionsOptions.setSelectedIndex(0);
           
           add(labelPanel);
           add(IOPanel);
           
           //Action listener created
           
           processRequest.addActionListener((ActionEvent e) -> {
        	   int studentID;
        	   //actions involving student record
        	   try {
        		   studentID = Integer.parseInt(id.getText());
        		   
        		   if ( studentID < 1) 
        			   throw new NumberFormatException();
        		   switch (actionsOptions.getSelectedIndex()) {
        		   case 0:
        			   //add student record
        			   if (map.containsKey(studentID) == true) {
        				   JOptionPane.showMessageDialog(null, "Record already exists");
        			   } 
        			   
        			   else {
        				   Student student = new Student(name.getText(), major.getText());
        				   map.put(studentID, student);
        				   
        				   JOptionPane.showMessageDialog(null, "Record successfully added");
        			   }
        			   break;
        		   case 1:
        			   //delete student record
        			   if(map.containsKey(studentID)) {
        				   map.remove(studentID); 
        					   JOptionPane.showMessageDialog(null, "Record successfully deleted");
        				   
        			   }
        			   
        			   else {
        				   JOptionPane.showMessageDialog(null, "Record does not exist");
        			   }
        			   break;
        		   case 2:
        			   //find student record
        			   if(map.containsKey(studentID)) {
        				   JOptionPane.showMessageDialog(null, map.get(studentID).toString());
        			   }
        			   else {
        				   JOptionPane.showMessageDialog(null, "Record does not exist");
        			   }
        			   break;
        		   case 3:
        			   //create combo box items for grades and credit
        			   String[] gradeList1 = { "A", "B", "C", "D", "F" };
                       String[] creditList1 = { "3", "6" };
                       int grade;
                       int credits;
        			   if(map.containsKey(studentID)) {
        				   String gradeValue = (String) JOptionPane.showInputDialog(null, "Choose grade:", "Grade", JOptionPane.QUESTION_MESSAGE, null, gradeList1, gradeList1[0]);
        				   String creditValue = (String) JOptionPane.showInputDialog(null, "Choose credits: ", "Credits", JOptionPane.QUESTION_MESSAGE, null, creditList1,creditList1[0] );
        				   credits = Integer.parseInt(creditValue);
        				   switch (gradeValue) {
        				   case "A":
        					   grade = 4;
        					   break;
        				   case "B":
        					   grade = 3;
        					   break;
        				   case "C":
        					   grade = 2;
        					   break;
        				   case "D":
        					   grade = 1;
        					   break;
        				   default:
        					   grade = 0;
        					   break;
        				   }
        				   Student student = (Student) map.get(studentID);
        				   student.courseCompleted(grade,  credits);
        				   JOptionPane.showMessageDialog(null, "Record successfully updated");
        			   } else {
        				   JOptionPane.showMessageDialog(null, "Record does not exist");
        			   }
        			   break;
        			   default:
        				   System.exit(0);
        			  }
        		   id.setText("");
        		   name.setText("");
        		   major.setText("");
        		   
        	   } catch (NumberFormatException nfe){
               
               JOptionPane.showMessageDialog(null, "Please enter a valid numeric student ID");
               
        	   	} 
           }
           );
	}

	public static void main(String[] args) {
		GUI student = new GUI();
		student.setTitle("Project 4");
		student.setSize(350,200);
		student.setLocationRelativeTo(null);
        student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        student.setResizable(false);
        student.setVisible(true);
	}

}
