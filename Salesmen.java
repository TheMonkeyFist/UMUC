/* Salesman.java
 * Author: Shawn Kelly
 * Novermber 5, 2017
 * Is-a relationship with Employees that also includes commission 
 */
public class Salesmen extends Employee {
	//private instance variables of Salesmen class
		private int annualSales;

		//constructor for all Salesmen
		public Salesmen (String name, int monthlySalary, int annualSales) {
			super(name, monthlySalary);
			this.annualSales = annualSales;
		}
		
		//method returns annual salary
		public int annualSalary() {
			int commission;
			if(annualSales * .02 >= 20000) {
				commission = 20000;
			} else {
				commission = (int) (annualSales * .02);
			}
			int annualSalary = super.annualSalary() + commission;
			return annualSalary;
		}
		
		//returns the results of the Salesmen information
		public String toString() {
			return super.toString() + "\n\tAnnual Sales: " + annualSales;
		}
}
