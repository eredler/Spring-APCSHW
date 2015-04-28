import java.util.*;

public class TreeNode<E> {

    private E value;
    private TreeNode<E> prev;
    public TreeNode<E> left = null;
    public TreeNode<E> right = null;

    public void setValue(E v){
	value = v;
    }

    public E getValue(){
	return value;
    }

    public boolean hasLeft(){
	return (left != null);
    }

    public boolean hasRight(){
	return (right != null);
    }
    
    public TreeNode<E> getLeft(){
	return left;
    }
    
    public TreeNode<E> getRight(){
	return right;
    }

    public void setLeft(TreeNode<E> l){
	left = l;
    }
    
    public void setRight(TreeNode<E> r){
	right = r;
    }
    
    public void setPrev(TreeNode<E> p){
	prev = p;
    }

    public TreeNode<E> getPrev(){
	return prev;
    }

    public boolean hasKids(){
	if (left != null || right != null){
	    return true;
	}
	return false;
    }

    public boolean room(){
	if (left == null || right == null){
	    return true;
	}
	return false;
    }
    
    public TreeNode(){
	setValue(null);
	setPrev(null);
    }

    public TreeNode(E v){
	setValue(v);
	setPrev(null);
    }

    public TreeNode(E v, TreeNode<E> p){
	setValue(v);
	setPrev(p);
    }

}
