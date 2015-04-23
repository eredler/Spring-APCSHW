import java.util.*;

public class TreeNode<E> {

    private E value;
    private TreeNode<E> prev;
    public ArrayList<TreeNode<E>> kids;
    private int maxKids;

    public void setValue(E v){
	value = v;
    }

    public E getValue(){
	return value;
    }

    public void setPrev(TreeNode<E> p){
	prev = p;
    }

    public TreeNode<E> getPrev(){
	return prev;
    }

    public void setMaxKids(int mk){
	maxKids = mk;
    }

    public int getMaxKids(){
	return maxKids;
    }

    public boolean room(){
	if (kids.size() >= maxKids){
	    return false;
	}
	return true;
    }
    
    public TreeNode(){
	setValue(null);
	setPrev(null);
	setMaxKids(2);
	kids = new ArrayList<TreeNode<E>>();
    }

    public TreeNode(E v){
	setValue(v);
	setPrev(null);
	setMaxKids(2);
	kids = new ArrayList<TreeNode<E>>();
    }

    public TreeNode(E v, int mk){
	setValue(v);
	setPrev(null);
	setMaxKids(mk);
	kids = new ArrayList<TreeNode<E>>();
    }

    public TreeNode(E v, TreeNode<E> p){
	setValue(v);
	setPrev(p);
	setMaxKids(2);
	kids = new ArrayList<TreeNode<E>>();
    }

    public TreeNode(E v, TreeNode<E> p, int mk){
	setValue(v);
	setPrev(p);
	setMaxKids(mk);
	kids = new ArrayList<TreeNode<E>>();
    }

}