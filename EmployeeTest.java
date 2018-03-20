import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* EmployeeTest.java
 * Author: Shawn Kelly
 * Novermber 5, 2017
 * Tests the inheritance of the Employee superclass with Salesmen and Executive subclasses
 * reading files of employee in 2014 and 2015
 */

public class EmployeeTest {

	public static void main(String[] args) {
		//input file location of employee data txt file
		String file = new String("C:\\Users\\Shawn\\Documents\\UMUC\\CMIS 242\\test.txt");
		//object counts total number of employees in file
		int people=0;
		try(BufferedReader company = new BufferedReader(new FileReader(file))) {
			String employee;
			while ((employee = company.readLine()) != null) {
				++people;
			}
			company.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Error reading file "+ file);
		}
		catch(IOException ex) {
			System.out.println("Error reading file "+ file);
		}
		//creates a 2d array of Employee data
		String help = "";
		String[] parts; 
		String[][] list = new String[people][];
		List<String> name = new ArrayList<String>();
		
		try(BufferedReader company = new BufferedReader(new FileReader(file))) {
			String employee;
			int currEmp = 0;
			while ((employee = company.readLine()) != null) {
				help = employee.toString();
				parts = help.split(" ");
				list[currEmp] = parts;
				currEmp++;
			}
			company.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("Error reading file "+ file);
		}
		catch(IOException ex) {
			System.out.println("Error reading file "+ file);
		}
		//Total objects for all employees money
		int total14 = 0;
		int cnt14 = 0;
		int total15 = 0;
		int cnt15 = 0;
		//prints all employees of 2014
		System.out.println("Employees 2014:");
		for(int i = 0; i < people; i++) {
			if(list[i][0].equals("2014")) {
			Employee curr;
			if(list[i][1].equals("Employee")) {
				curr = new Employee(list[i][2],Integer.parseInt(list[i][3]));
			} else if(list[i][1].equals("Salesmen")) {
				curr = new Salesmen(list[i][2],Integer.parseInt(list[i][3]), Integer.parseInt(list[i][4]));
			} else if(list[i][1].equals("Executive")) {
				curr = new Executive(list[i][2],Integer.parseInt(list[i][3]), Integer.parseInt(list[i][4]));
			} else {
				curr = new Employee("Not Real", 0);
			}
			System.out.print(curr.toString());
			System.out.println("\n\tAnnual Salary: " + curr.annualSalary());
			total14+=curr.annualSalary();
			cnt14++;
			}
		}
		System.out.println("\n\tAverage of all Salaries 2014: "+ total14/cnt14);
		//Prints all employees of 2015
		System.out.println("Employees 2015:");
		for(int i = 0; i < people; i++) {
			if(list[i][0].equals("2015")) {
				
			Employee curr;
			if(list[i][1].equals("Employee")) {
				curr = new Employee(list[i][2],Integer.parseInt(list[i][3]));
			} else if(list[i][1].equals("Salesmen")) {
				curr = new Salesmen(list[i][2],Integer.parseInt(list[i][3]), Integer.parseInt(list[i][4]));
			} else if(list[i][1].equals("Executive")) {
				curr = new Executive(list[i][2],Integer.parseInt(list[i][3]), Integer.parseInt(list[i][4]));
			} else {
				curr = new Employee("Not Real", 0);
			}
			System.out.print(curr.toString());
			System.out.println("\n\tAnnual Salary: " + curr.annualSalary());
			total15+=curr.annualSalary();
			cnt15++;
		}
		}
		System.out.println("Average of all Salaries 2015: "+ total15/cnt15);
	}

}
