import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    private BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
      BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if (curr == null){
	    return t;
	} else if (curr.getData().compareTo(t.getData()) > 0){
	    curr.setLeft(add(curr.getLeft(),t));
	} else {
	    curr.setRight(add(curr.getRight(),t));
	}
	return curr;
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
      T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	return null;
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	else if (!t.hasLeft() && !t.hasRight()) {
	    System.out.println(t.toString());
	    return;
	}
	inOrderHelper( t.getLeft() );
	System.out.println(t);
	inOrderHelper( t.getRight() );
    }

    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(BSTreeNode<T> r ){
	if(r == null){
	    return 0;
	}else{
	    //System.out.println("recursion height");
	    return 1 + Math.max(getHeight(r.getLeft()),
				getHeight(r.getRight()));
	}
    }

    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }

    private int maxLength(BSTreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }

    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }

    private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
	if (currLevel == 1)
	    return curr.toString() + spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * Math.pow(2, height - targetLevel + 1) - wordLength);
	String result = "";
	if (curr.getLeft() != null){
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
	} else {
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	if (curr.getRight() != null){
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	} else {result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	return result;
    }

    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++) {
	    // remove extra spaces from the end of each level's String to prevent lines from
	    // getting unnecessarily long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	}
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
	return result;
    }

    

    public static void main( String[] args ) {

	BSTree bst = new BSTree();

	bst.add(4);
	bst.add(1);
	bst.add(9);
	bst.add(5);
	bst.add(2);
	bst.add(7);
	//	bst.add(6);
	//	bst.add(7);
	//	bst.add(8);
	//	bst.add(9);
	bst.inOrder();
	System.out.println(bst);
	
    }

}
