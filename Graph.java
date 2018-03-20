/* Graph.java
 * Author: Shawn Kelly
 * March 4, 2018
 * Creates Graph and solves guild path depending on start class
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Graph {

	//creates private static lists for the graph
    private static LinkedList<Integer> graph[];
    private static HashMap<String, Integer> classMap = new HashMap<>();
    private static int totalClass = 0;
    
    //creates graph based off of file path to .txt file
    public static boolean buildGraph(String fileName) {
    	try {
    		//checks for file
    		Scanner sc = new Scanner(new File(fileName));
    		//checks in file
    		while(sc.hasNext()) {
    			String line = sc.nextLine();
    			//Breaks up line into the seperate classes
    			String[] inClass = line.split(" ");
    			
    			for(String className : inClass) {
    				//hash maps className and assigns a value to each class
    				classMap.put(className, className.charAt(className.length()-1)-'A');
    			}
    		}
    		 totalClass = classMap.size();
    		 graph = new LinkedList[totalClass];
    		 
    		 sc = new Scanner(new File(fileName));
    		 
    		 while(sc.hasNext()) {
    			 String line = sc.nextLine();
    			 //Stores groups of classes in each section
    			 String[] inClass = line.split("[ \n]");
    			 graph[classMap.get(inClass[0])] = new LinkedList<>();
    			 for(int i = 1; i < inClass.length; i++) {
    				 graph[classMap.get(inClass[0])].add(classMap.get(inClass[i]));
    			 }
    		 }
    		 return true;
    	} catch (FileNotFoundException ex) {
    		return false;
    	}
    }
    
    //Based off of the Class given displays the logical the graph for calling the original class
  public static ArrayList<String> topologicalSort(String source){
        
        boolean visited[] = new boolean[totalClass];
        boolean finished[] = new boolean[totalClass];
        Stack<Integer> order = new Stack<>();
        
        try {
            dfs(visited, finished, order, classMap.get(source));
        } catch (CycleDetectedException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(order.size() > 0 && order.get(order.size() - 1) != -1){
            ArrayList<String> orderOfClass = new ArrayList<>();
            
            while(!order.empty()){
                char ch;
                ch = (char) (65 + order.pop());
                orderOfClass.add("Class" + ch);
            }
            return orderOfClass;
        }
        return null;
    }
    
    //method to validate Class Name
    public static boolean matchName(String className){ 
        boolean contains = classMap.keySet().contains(className);
     
        return contains;
    }
    
    //Search vertices until the chain ends using DepthFirstSearch
    public static void dfs(boolean visited[], boolean finished[], Stack<Integer> order, int source) throws CycleDetectedException{
       
        if(visited[source]){
          
                throw new CycleDetectedException("Cycle Detected");
               
        
           
        }
        else if(finished[source])
            return;
        visited[source]=true;
        
        if(graph[source]!=null){
            //loop through
            graph[source].stream().forEach((Integer adj) -> {
                try {
                    //recursive
                    dfs(visited,finished,order,adj);
                } catch (CycleDetectedException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            });
            
        }
        
        finished[source]=true;
        order.add(source);
    }
   
    
   public static void addEdge(String source, String dest){
       //if both source and destination already exist
       if(classMap.containsKey(source) && classMap.containsKey(dest)){
           graph[classMap.get(source)].add(classMap.get(dest));
       }
      
       else{
           JOptionPane.showMessageDialog(null, "Either Source or Destination Doesn't Exist");
       }
       
    }
}
