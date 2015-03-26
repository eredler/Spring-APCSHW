import java.util.*;

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
	if (d[head] != null){
	    if (head == 0){
		head = d.length-1;
	    } else {
		head--;
	    }
	}
	d[head] = value;
	size++;
	
    }

    public void addLast(T value){
	// when array is full, resize, then add
	if (size >= d.length-1){
	    resizeCopy();
	}
	if (tail >= d.length){
	    tail = 0;
	} else {
	    tail++;
	}
	d[tail] = value;
	size++;
    }

    public T removeFirst(){
	// throws NoSuchElementException
	try {
	    T hold = (T)d[head];
	    d[head] = null;
	    if (head == d.length){
		head = 0;
	    } else {
		head++;
	    }
	    return hold;
	} catch (NoSuchElementException e){
	    throw new NoSuchElementException();
	}
    }

    public T removeLast(){
	// throws NoSuchElementException
	try {
	    T hold = (T)d[tail];
	    d[tail] = null;
	    if (tail == 0){
		tail = d.length;
	    } else {
		tail--;
	    }
	    return hold;
	} catch (NoSuchElementException e){
	    throw new NoSuchElementException();
	}
    }

    public T getFirst(){
	// throws NoSuchElementException
	try {
	    return (T)d[head];
	} catch (NoSuchElementException e){
	    throw new NoSuchElementException();
	}
    }

    public T getLast(){
	// throws NoSuchElementException
	try {
	    return (T)d[tail];
	  
	} catch (NoSuchElementException e){
	    throw new NoSuchElementException();
	}
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
	d = ans;
	head = 0;
	tail = size;
    }

    public static void main(String[]args){
	MyDeque<String> md = new MyDeque<String>();

	md.addFirst("hi");
	System.out.println(md.getFirst()); // hi
	md.addFirst("hello");
	System.out.println(md.getFirst()); // hello	
	System.out.println(md.getLast()); // hi
	md.addFirst("emily");
	md.addLast("redler");
	System.out.println(md.getFirst()); // emily
	System.out.println(md.getLast()); // redler
	md.addFirst("ice cream"); 
	md.addLast("jelly");
	System.out.println(md.getFirst()); // ice cream
	System.out.println(md.removeFirst()); // ice cream
	System.out.println(md.getFirst()); // emily
	System.out.println(md.removeLast()); // jelly
	System.out.println(md.getLast()); // redler

	
    }
    
}
