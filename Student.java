/* Student.java
 * Author: Shawn Kelly
 * December 16, 2017
 * Defines the methods used to add, remove, and look up students information
*/
public class Student {

		//variables for student logs
	private String studentName;
	private String major;
	private int credits;
	private int qualityPoints;
	private boolean isCompleted = false;
	
		//Constructor for each student record
	public Student(String studentName, String major) {
		this.studentName = studentName;
		this.major = major;
		credits = 0;
		qualityPoints = 0;
	}
	
		//method to update variables used to compute the GPA
	public void courseCompleted(int grade, int creditHours) {
		credits += creditHours;
		qualityPoints += (grade * creditHours);
		isCompleted = true;
	}
	@Override
	public String toString() {
		if(!isCompleted) {
			return "Name: " + studentName + ", Major: " + major + ", GPA: 4.0";
		}
		double gpa = qualityPoints / credits;
        return "Name: " + studentName + ", Major: " + major + ", GPA: " + gpa;
	}

}
