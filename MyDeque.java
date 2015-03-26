public class MyDeque<T> {
    public T[] d;
    public int size;
    public int head;
    public int tail;

    public MyDeque(){
	d = new T[10];
	size = 0;
	head = 0;
	tail = 0;
    }

    public void addFirst(T value){
	// when array is full, resize, then add
	if (size >= d.length-1){
	    resizeCopy();
	}
	
    }

    public void addLast(T value){
	// when array is full, resize, then add
    }

    public T removeFirst(){
	// throws NoSuchElementException
    }

    public T removeLast(){
	// throws NoSuchElementException
    }

    public T getFirst(){
	// throws NoSuchElementException
    }

    public T getLast(){
	// throws NoSuchElementException
    }

    public void resizeCopy(){
	// resize array (double) and copy to new array
	T[] ans = new T[d.length*2];
	for (int i = head, x = 0; i < d.length; x++, i++){
	    ans[x] = d[i];
	} 
    }

}
