/* Sequence.java
 * Author: Shawn Kelly
 * December 2, 2017
 * Handles all class methods. Is the utility class for Project 3
*/


public class Sequence {
    
    static int efficiency;

    //Method to iteratively calculate results and efficiency
    public static int computeIterative(int n) {
        int result = 0;
        if (n == 0) {
            result = 0;
            efficiency = 1;
        } else if (n == 1) {
            result = 1;
            efficiency = 1;
        } else {
            int secondPrevious = 0;
            int previous = 1;
            for (int i = 2; i <= n; i++) {
                efficiency++;
                result = 2 * previous + secondPrevious;
                secondPrevious = previous;
                previous = result;
            }
        }
        return result;
    }
    
    // Method to recursively calculate results and efficiency
    public static int computeRecursive(int n) {
      return recursive(n);
    }
    
    private static int recursive(int n) {
    	 int result;
         efficiency++;
         if (n == 0) {
             result = 0;
         } else if (n == 1) {
             result = 1;
         } else {
             result = 2 * recursive(n - 1) + recursive(n - 2);
         }
         return result;
    }
    
    public static int getEfficiency(){
        return efficiency;
  
    }
    
}
