import java.util.*;

public class MyDeque<T> {
    public Object[] d;
    public int size;
    public int head;
    public int tail;
    public boolean shrinkOn = false;
    public boolean debugPrint = false;

    public MyDeque(){
	d = new Object[10];
	size = 0;
	head = 5;
	tail = 4;
    }

    public MyDeque(int n){
	d = new Object[n];
	size = 0;
	head = 0;
	tail = 0;
    }

    public String toString(){
	if (debugPrint == true){
	    return Arrays.toString(d);
	}
	String ans = "[" + d[head];
	if (head < tail){
	    for (int i = head+1; i <= tail; i++){
		ans += ", " + d[i];
	    }
	    ans += "]";
	    return ans;
	}
	int x = 1;
	for (int i = head+1; i < d.length; i++){
	    ans += ", " + d[x];
	    x++;
	}
	for (int i = 0; i <= tail; i++){
	    ans += ", " + d[x];
	    x++;
	}
	ans += "]";
	return ans;
    }

    public void addFirst(T value){
	// when array is full, resize, then add
	if (size == d.length){
	    grow();
	}
	head--;
	if (head == -1){
	    head = d.length-1;
	}
	d[head] = value;
	size++;
	
    }

    public void addLast(T value){
	// when array is full, resize, then add
	if (size == d.length){
	    grow();
	}
	tail++;
	if (tail == d.length){
	    tail = 0;
	}
	d[tail] = value;
	size++;
    }

    public T removeFirst(){
	// throws NoSuchElementException
	try {	    
	    if ((size <= d.length/4) && shrinkOn){
		shrink();
	    }
	    size--;
	    T hold = (T)d[head];
	    head++;
	    if (head == d.length){
		head = 0;
	    }
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
	    size--;
	    T hold = (T)d[tail];
	    tail--;
	    if (tail == -1){
		tail = d.length-1;
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
	    if (Integer.parseInt(args[0]) == 1){
		md.debugPrint = true;
	    } 
	    if (Integer.parseInt(args[1]) == 1){
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
	System.out.println(md.toString());

	
    }
    
}
