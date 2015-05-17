import java.util.*;

public class MyHeap {

    private int[] heap;

    final static boolean MAX_HEAP = true;
    final static boolean MIN_HEAP = false;

    public boolean mode;

    public int size;

    public String name(){
	return "Redler, Emily";
    }

    public MyHeap() {
	mode = MAX_HEAP;
	heap = new int[10];
	size = 0;
    }

    public MyHeap(boolean m){
	mode = m;
	heap = new int[10];
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
    
    private void literallyJustSwap(int firstIndex, int secondIndex){
	int hold = heap[firstIndex];
	heap[firstIndex] = heap[secondIndex];
	heap[secondIndex] = hold;
    }

    private void complicatedSwap(int index){
	if (index == 0){
	    return;
	} else if (compare(index,getParent(index))){
	    literallyJustSwap(index,getParent(index));
	    complicatedSwap(getParent(index));
	}
    }

    private void pushUp(int index){
	if (getLeft(index) > size){
	    return;
	}
	if (!compare(index,getLeft(index))){
	    literallyJustSwap(index,getLeft(index));
	    pushUp(getLeft(index));
	}
    }   

    private boolean compare(int x, int y){
	if (mode == MAX_HEAP){
	    return (heap[x] > heap[y]);
	} else {
	    return (heap[x] < heap[y]);
	}
    }

    public String toString() {
	if (size == 0){
	    return "[]";
	}
	return (Arrays.toString(Arrays.copyOfRange(heap,0,size)));
    }

    public Integer remove(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	Integer hold = heap[0];
	heap[0] = heap[size];
	pushUp(1);
	size--;
	return hold;
    }

    public void add(Integer v){
	heap[size+1] = v;
	complicatedSwap(size+1);
	size++;
	resize();
    }

    private void resize() {
	if (size == heap.length - 1) {
	    heap = Arrays.copyOf(heap, size * 2);
	} else if (size < heap.length / 2 && size > 10) {
	    heap = Arrays.copyOf(heap, heap.length / 2);
    }
    }

    public int peek(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return heap[0];
    }

    public static void main(String[]args){
	MyHeap h = new MyHeap(); 
	h.add(3);
	h.add(10);
	h.add(5);
	h.add(7);
	h.add(-8);
	System.out.println(h); 
	h.remove();
	System.out.println(h); 
    }

}
