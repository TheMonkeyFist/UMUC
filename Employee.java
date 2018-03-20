/* Employee.java
 * Author: Shawn Kelly
 * Novermber 5, 2017
 * has-a relationship with Salesmen and Executive classes that is all employees
 */
public class Employee {
	//private instance variables of employee class
	private String name;
	private int monthlySalary;

	//constructor for all employees
	public Employee (String name, int monthlySalary) {
		this.name = name;
		this.monthlySalary = monthlySalary;
	}
	
	//method returns annual salary
	public int annualSalary() {
		int annualSalary = monthlySalary * 12;
		return annualSalary;
	}
	
	//returns the results of the employee information
	public String toString() {
		return "\n\tName: " + name + "\n\tMonthly Salary: " + monthlySalary;
	}
}
