import java.util.*;

public class MyDeque<T> {
    public Object[] d;
    public int size;
    public int head;
    public int tail;
    public boolean shrinkOn = false;

    public MyDeque(){
	d = new Object[5];
	size = 0;
	head = 0;
	tail = 0;
    }

    public String toString(){
	return Arrays.toString(d);
    }

    public void addFirst(T value){
	// when array is full, resize, then add
	if (size+1 > d.length){
	    grow();
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
	if (size+1 > d.length){
	    grow();
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
	    if ((size+1 <= d.length/4) && shrinkOn){
		shrink();
	    }
	    T hold = (T)d[head];
	    d[head] = null;
	    if (head >= d.length-1){
		head = 0;
	    } else {
		head++;
	    }
	    size--;
	    return hold;
	} catch (NoSuchElementException e){
	    throw new NoSuchElementException();
	}
    }

    public T removeLast(){
	// throws NoSuchElementException
	try {
	    if ((size+1 <= d.length/4) && shrinkOn){
		shrink();
	    }
	    T hold = (T)d[tail];
	    d[tail] = null;
	    if (tail == 0){
		tail = d.length;
	    } else {
		tail--;
	    }
	    size--;
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

    public void grow(){
	// resize array (double) and copy to new array
	Object[] ans = new Object[d.length*2];
	int x = 0;
	for (int i = head; i < d.length || i <= tail; i++){
	    ans[x] = d[i];
	    x++;
	} 
	if (tail < head){
	    for (int i = 0; i <= tail; i++){
		ans[x] = d[i];
		x++;
	    }
	}
	d = ans;
	head = 0;
	tail = x-1;
    }

    public void shrink(){
	// resize array (half) and copy to new array
	Object[] ans = new Object[d.length/2];
	int x = 0;
	if (head < tail){
	    for (int i = head; i <= tail; i++){
	    ans[x] = d[i];
	    x++;
	    }
	} else {
	    for (int i = head; i < d.length; i++){
		ans[x] = d[i];
		x++;
	    } 
	    for (int i = 0; i <= tail; i++){
		ans[x] = d[i];
		x++;
	    }
	}
	d = ans;
	head = 0;
	tail = x-1;
    }

    public static void main(String[]args){	
	MyDeque<String> md = new MyDeque<String>();

	try {
	    if (args[0] == "t"){
		md.shrinkOn = true;
	    } else {
		md.shrinkOn = true;
	    }
	} catch (ArrayIndexOutOfBoundsException e){

	}


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
