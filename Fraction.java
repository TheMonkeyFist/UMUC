import java.util.ArrayList;

/* Fraction.java
 * Author: Shawn Kelly
 * February 18, 2018
 * Defines what a fraction is so they can be handled in the BST
*/
public class Fraction implements Comparable{
	
	//private variables of a fraction
	private int numerator;
	private int denominator;
	
	public Fraction() {
		
	}
	//constructor
	public Fraction(String e) {
		char curr;
		int limbo = 0;
		int counter = 0;
		ArrayList<Character> limboLst = new ArrayList<Character>();
		//checks for multiple digit numbers
		for(int i = 0; i <e.length();i++) {
				curr = e.charAt(i); 
			if((curr == '0' ||
				curr == '1' ||
				curr == '2' ||
				curr == '3' ||
				curr == '4' ||
				curr == '5' ||
				curr == '6' ||
				curr == '7' ||
				curr == '8' ||
				curr == '9') &&
				i != e.length() -1 
					) {
					limboLst.add(curr);
			}
			
			//if a division brings number into the numerator
			else if(curr == '/') {
				counter++;
				
				int y = 0;
				for(int j = limboLst.size() - 1;j >= 0; j--) {
					limbo += (int)Math.pow(10, j)*((int)limboLst.get(y)-48);
					y++;
				}
				setNum(limbo);
				limbo = 0;
				limboLst.clear();
			}
			
			//bring number int the denominator and puts fraction into array list
			else if(curr == ' '|| i == e.length()-1) {
				limboLst.add(curr);
				int y = 0;
				counter = 0;
				for(int j = limboLst.size() - 1;j >= 0; j--) {
					limbo += (int)Math.pow(10, j)*((int)limboLst.get(y)-48);
					y++;
				}
				setDen(limbo);
				limbo = 0;
				limboLst.clear();
			}
			
			
			}
		}
		

	//getters and setters for numerator and denominator
	public void setNum(Integer e) {
		numerator = e;
	}
	
	public void setDen(int e) {
		denominator = e;
	}
	
	public int getNum() {
		return numerator;
	}
	
	public int getDen() {
		return denominator;
	}
	
	//prints out the fraction
	@Override
	public String toString() {
		String fraction = getNum() + "/" + getDen();
		return fraction;
	}
	
	//compares two Fractions to find the larger of the two
	@Override
	public int compareTo(Object e) {
		//make object into a fraction
		Fraction fraction = (Fraction)e;
		int e1 = fraction.getNum()/fraction.getDen();
		int e2 = numerator/denominator;
		if(e1 < e2) {
			return 1;
		}
		if(e1 >= e2) {
			return -1;
		}
		return 0;
	}
	
	
}
