import java.util.*;

public class MyHeap {

    private ArrayList<Integer> heap;

    final static boolean MAX_HEAP = true;
    final static boolean MIN_HEAP = false;

    public boolean mode;

    public Integer root;

    public MyHeap() {
	mode = MAX_HEAP;
	heap = new ArrayList<Integer>();
	root = null;
    }

    public MyHeap(boolean m){
	mode = m;
	heap = new ArrayList<Integer>();
	root = null;
    }

    public String toString(){
	return heap.toString();
    }
    

    public Integer remove(){
	Integer hold = root;
	heap.remove(root);
	root = heap.get(0);
	return hold;
    }

    public void add(Integer v){
	if (root == null){
	    root = v;
	} else if (mode == MAX_HEAP){
	    if (v >= root){
		heap.add(0,v);
		root = v;
	    } else {
		for (int i = 0; i < heap.size(); i++){
		    if (heap.get(i) < v){
			heap.add(i,v);
			return;
		    }
		    heap.add(heap.size(),v);
		    return;
		}
	    }
	} else {
	    if (v <= root){
		heap.add(0,v);
		root = v;
	    } else {
		for (int i = 0; i < heap.size(); i++){
		    if (heap.get(i) > v){
			heap.add(i,v);
			return;
		    }
		    heap.add(heap.size(),v);
		    return;
		}
	    }
	}
    }

    public int peek(){
	return root;
    }

}
