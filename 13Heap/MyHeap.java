import java.util.*;

public class MyHeap {

    private ArrayList<Integer> heap;

    final static boolean MAX_HEAP = true;
    final static boolean MIN_HEAP = false;

    public boolean mode;

    public int size;

    public MyHeap() {
	mode = MAX_HEAP;
	heap = new ArrayList<Integer>();
	size = 0;
    }

    public MyHeap(boolean m){
	mode = m;
	heap = new ArrayList<Integer>();
	size = 0;
    }

    private int getLeft(int index){
	return index*2;
    }

    private int getRight(int index){
	return index*2+1;
    }

    private int getParent(int index){
	return index/2;
    }
    
    private void swap(int firstIndex, Integer secondIndex){
	Integer hold = heap.get(firstIndex);
	heap.set(firstIndex,heap.get(secondIndex));
	heap.set(secondIndex,hold);
    }

    private void swapHelp(int index){
	if (index == 0){
	    return;
	} else if (compare(index,getParent(index))){
	    swap(index,getParent(index));
	    swapHelp(getParent(index));
	}
    }

    private void pushUp(int index){
	if (getLeft(index) > size){
	    return;
	}
	if (!compare(index,getLeft(index))){
	    swap(index,getLeft(index));
	    pushUp(getLeft(index));
	}
    }   

    private boolean compare(int x, int y){
	if (mode == MAX_HEAP){
	    return (heap.get(x) > heap.get(y));
	} else {
	    return (heap.get(x) < heap.get(y));
	}
    }

    public String toString() {
	return heap.toString();
    }
    

    public Integer remove(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	Integer hold = heap.get(1);
	heap.set(1,heap.get(size));
	pushUp(1);
	size--;
	return hold;
    }

    public void add(Integer v){
	heap.set(size+1,v);
	swapHelp(size+1);
	size++;
    }

    public int peek(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return heap.get(1);
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap();
	System.out.println(h); 
	h.add(3);
	System.out.println(h); 
	h.add(10);
	h.add(5);
	h.add(7);
	h.add(-8);
	System.out.println(h);    
    }

}
