import java.util.*;

public class MyHeap {

    private ArrayList<Integer> heap;

    final static boolean MAX_HEAP = true;
    final static boolean MIN_HEAP = false;

    public boolean isMax;

    public MyHeap() {
	isMax = MAX_HEAP;
	heap = new ArrayList<Integer>();
    }

    public MyHeap(boolean _isMax){
	isMax = _isMax;
    }

    public String toString(){
	return heap.toString();
    }
    

    public int remove(){

    }

    public void add(int v){

    }

    public int peek(){

    }

}
