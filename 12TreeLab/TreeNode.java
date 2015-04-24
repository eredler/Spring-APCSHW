import java.util.*;

public class TreeNode<E> {

    private E value;
    private TreeNode<E> prev;
    public ArrayList<TreeNode<E>> kids;
    private int maxKids = 2;

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

    public boolean hasKids(){
	if (kids.size() > 0){
	    return true;
	}
	return false;
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
	kids = new ArrayList<TreeNode<E>>();
    }

    public TreeNode(E v){
	setValue(v);
	setPrev(null);
	kids = new ArrayList<TreeNode<E>>();
    }

    public TreeNode(E v, TreeNode<E> p){
	setValue(v);
	setPrev(p);
	kids = new ArrayList<TreeNode<E>>();
    }

}