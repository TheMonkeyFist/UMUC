/* Executive.java
 * Author: Shawn Kelly
 * Novermber 5, 2017
 * Is-a relationship with Employees that also includes bonus for higher stock price
 */
public class Executive extends Employee{
	//private instance variables of Executive class
	private int stockPrice;

	//constructor for all Executive
	public Executive (String name, int monthlySalary, int StockPrice) {
		super(name, monthlySalary);
		this.stockPrice = StockPrice;
	}
	
	//method returns annual salary
	public int annualSalary() {
		int bonus;
		if(stockPrice >= 50) {
			bonus = 30000;
		} else {
			bonus = 0;
		}
		int annualSalary = super.annualSalary() + bonus;
		return annualSalary;
	}
	
	//returns the results of the Executive information
	public String toString() {
		return super.toString() + "\n\tStock Price: " + stockPrice;
	}
}
