public class TreeNode<E> {

    private E value;
    private TreeNode<E> prev;
    private ArrayList<TreeNode<E>> kids;
    private int numKids;
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

    public void setNumKids(int nk){
	numKids = nk;
    }

    public int getNumKids(){
	return numKids;
    }

    public void setMaxKids(int mk){
	maxKids = mk;
    }

    public int getMaxKids(){
	return maxKids;
    }

    public boolean room(){
	if (nk >= mk){
	    return false;
	}
	return true;
    }
    
    public TreeNode(){
	setValue(null);
	setPrev(null);
	setNumKids(0);
	setMaxKids(2);
	kids = new ArrayList<TreeNode<E>>();
    }

    public TreeNode(E v){
	setValue(v);
	setPrev(null);
	setNumKids(0);
	setMaxKids(2);
	kids = new ArrayList<TreeNode<E>>();
    }

    public TreeNode(E v, ink mk){
	setValue(v);
	setPrev(null);
	setNumKids(0);
	setMaxKids(mk);
    }

    public TreeNode(E v, int mk, int nk){
	setValue(v);
	setPrev(null);
	setNumKids(nk);
	setMaxKids(mk);
	kids = new ArrayList<TreeNode<E>>();
    }

    public TreeNode(E v, TreeNode<E> p){
	setValue(v);
	setPrev(p);	
	setNumKids(0);
	setMaxKids(2);
	kids = new ArrayList<TreeNode<E>>();
    }

    public TreeNode(E v, TreeNode<E> p, int mk){
	setValue(v);
	setPrev(p);	
	setNumKids(0);
	setMaxKids(mk);
	kids = new ArrayList<TreeNode<E>>();
    }
    
    public TreeNode(E v, TreeNode<E> p, int mk, int nk){
	setValue(v);
	setPrev(p);	
	setNumKids(nk);
	setMaxKids(mk);
	kids = new ArrayList<TreeNode<E>>();
    }

}