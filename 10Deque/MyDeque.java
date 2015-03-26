public class MyDeque<T> {
    public Object[] d;
    public int size;
    public int head;
    public int tail;

    public MyDeque(){
	d = new Object[10];
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
	Object[] ans = new Object[d.length*2];
	int x = 0;
	for (int i = head; i < d.length || i < tail; i++){
	    ans[x] = d[i];
	    x++;
	} 
	if (tail < head){
	    for (int i = tail; i < head; i++){
		ans[x] = d[i];
		x++;
	    }
	}

    }

}
