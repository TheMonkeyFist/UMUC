import java.util.*;
import javax.swing.*;
import javax.swing.JOptionPane;

/* PerformSort.java
 * Author: Shawn Kelly
 * February 18, 2018
 * Creates a BST with recursion and
 *  performs in order traversal
*/
public class PerformSort {
	//first node is created to start the tree
	private Node root;
	private ArrayList<Integer> ascending = new ArrayList<Integer>();
	private ArrayList<Fraction> ascendingF = new ArrayList<Fraction>();
	
	
	/*
	 * Integer type methods
	 */
	
	//returns a string of the list in ascending order
	public String ascending() {
		String inorder = "";
		for(int i = 0; i < ascending.size(); i++)
		 inorder += ascending.get(i) + " ";
		return inorder;
	}
	
	//returns a string of the list in descending order
	public String descending() {
		String inorder = "";
		for(int i = ascending.size() - 1; i >= 0; i--)
		 inorder += ascending.get(i) + " ";
		return inorder;
	}
	
	
	//calls the recursive method insertRec
	public void insert(int key) {
		root = insertRec(root, key);
	}
	
	//Recursively adds new nodes to a tree
	private Node insertRec(Node root,int key) {
		//if tree is empty returns new node
		if (root == null) {
			root = new Node(key);
			return root;
		} 
		//follows down the tree
		else if (key > root.key) {
			root.right = insertRec(root.right, key);
		} else if (key <= root.key) {
			root.left = insertRec(root.left, key);
		}
		//returns root pointer
		return root;
	}
	

	//calls recursive method sortRec
	public void sort() {
		sortRec(root);
	}
	
	//recusively creates an inorder string of BST
	private void sortRec(Node root) {
		if(root != null) {
			sortRec(root.left);
			ascending.add(root.key);
			sortRec(root.right);
		}
	}
	
	//loops through user input string to create an array list for integers
	public ArrayList<Integer> getArrayListN(String text) throws NumberFormatException{
	char curr;
	int limbo = 0;
	ArrayList<Integer> rawValues = new ArrayList<Integer>();
	ArrayList<Character> limboLst = new ArrayList<Character>();
	//checks for multiple digit numbers
	for(int i = 0; i <text.length();i++) {
			curr = text.charAt(i);
		if(i == text.length() -1 ) {
			limboLst.add(curr);
		}
		if(	(curr == '0' ||
			curr == '1' ||
			curr == '2' ||
			curr == '3' ||
			curr == '4' ||
			curr == '5' ||
			curr == '6' ||
			curr == '7' ||
			curr == '8' ||
			curr == '9') &&
			i != text.length() -1 
				) {
				limboLst.add(curr);
		}
		else if(curr == ' '|| i == text.length()-1) {
			int y = 0;
			for(int j = limboLst.size() - 1;j >= 0; j--) {
				limbo += (int)Math.pow(10, j)*((int)limboLst.get(y)-48);
				y++;
			}
			rawValues.add(limbo);
			limbo = 0;
			limboLst.clear();
		}
		else {
			throw new NumberFormatException ();
		}
		}
	return rawValues;
	}
	
	/*
	 * Fraction type methods
	 */
	
	//Fraction methods to create a descending and ascending String
	public String ascendingF() {
		String inorder = "";
		for(int i = 0; i < ascendingF.size(); i++)
			 inorder += ascendingF.get(i).toString() + " ";
			return inorder;
	}
	
	public String descendingF() {
		String inorder = "";
		for(int i = ascendingF.size() - 1; i >= 0; i--)
		 inorder += ascendingF.get(i).toString() + " ";
		return inorder;
	}
	
	
	
	//loops through user input string to create an array list for fractions
	public ArrayList<Fraction> getArrayListF(String text) throws NumberFormatException{
		char curr;
		Fraction temp;
		int start = 0;
		ArrayList<Fraction> rawValues = new ArrayList<Fraction>();
		//checks for multiple digit numbers
		for(int i = 0; i < text.length(); i++) {
			curr = text.charAt(i);
			if(curr == ' ') {
				String frac = text.substring(start, i);
				start = ++i;
				temp = new Fraction(frac);
				rawValues.add(temp);
			}
			if(i == text.length() - 1) {
				String frac = text.substring(start, text.length());
				temp = new Fraction(frac);
				rawValues.add(temp);
			}
		}
		return rawValues;
		}
	
	//calls the recursive method insertRec
	public void insertF(Fraction key) {
		root = insertRecF(root, key);
	}
	
	//Recursively adds new nodes to a tree
	private Node insertRecF(Node root,Fraction key) {
		//if tree is empty returns new node
		if (root == null) {
			root = new Node(key);
			return root;
		} 
		//follows down the tree
		else if (key.compareTo(root.keyF) > 0) {
			root.right = insertRecF(root.right, key);
		} else if (key.compareTo(root.keyF) <= 0) {
			root.left = insertRecF(root.left, key);
		}
		//returns root pointer
		return root;
	}
	

	//calls recursive method sortRec
	public void sortF() {
		sortRecF(root);
	}
	
	//recusively creates an inorder string of BST
	private void sortRecF(Node root) {
		if(root != null) {
			sortRecF(root.left);
			ascendingF.add(root.keyF);
			sortRecF(root.right);
		}
	}

	//Nodes for the BST
	public class Node {

		int key;Fraction keyF;
		Node left, right;
		//constructor
		public Node(int e) {
			key = e;
		left = right = null;	
		}
		public Node(Fraction e) {
			keyF = e;
			left = right = null;	
		}
	}
}
