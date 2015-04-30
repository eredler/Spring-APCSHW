import java.io.*;
import java.util.*;

public class BSTreeNode<T extends Comparable> {

    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;

    private int numOf;

    public BSTreeNode( T d ) {
 
	data = d;
	left = right = null;
	setNumOf(1);

    }
    
    //accessors
    public T getData() {
	return data;
    }
    public BSTreeNode<T> getLeft() {
	return left;
    }
    public BSTreeNode<T> getRight() {
	return right;
    }
    public int getNumOf(){
	return numOf;
    }

    //mutators
    public void setData( T d ) {
	data = d;
    }
    public void setLeft( BSTreeNode<T> l ) {
	left = l;
    }
    public void setRight( BSTreeNode<T> r ) {
	right = r;
    }
    public void setNumOf(int n){
	numOf = n;
    }

    public int compareTo(BSTreeNode<T> b){

    }
}
