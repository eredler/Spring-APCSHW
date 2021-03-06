import java.util.*;

public class MyDeque<T> {
    public Object[] d;
    public Integer[] pri;
    public int size;
    public int head;
    public int tail;
    public boolean shrinkOn = false;
    public boolean debugPrint = false;

    public boolean priorityQ = false;

    public MyDeque(){
	d = new Object[100];
	pri = new Integer[100];
	size = 0;
	head = 5;
	tail = 4;
    }

    public MyDeque(int n){
	d = new Object[n];
	pri = new Integer[n];
	size = 0;
	head = 5;
	tail = 4;
    }

    public void setPriQ(boolean b){
	priorityQ = b;
    }

    public String toString(){
	if (debugPrint == true){
	    return Arrays.toString(d);
	}
	String ans = "[" + d[head];
	if (head <= tail){
	    for (int i = head+1; i <= tail; i++){
		ans += ", " + d[i];
	    }
	    ans += "]";
	    return ans;
	}
	int x = 1;
	for (int i = head+1; i < d.length; i++){
	    ans += ", " + d[i];
	    x++;
	}
	for (int i = 0; i <= tail; i++){
	    ans += ", " + d[i];
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
	if (head <= 0){
	    head = d.length;
	}
	head--;
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
	Integer[] ansPri = new Integer[d.length*2];
	int x = 0;
	for (int i = head; i < d.length || i <= tail; i++){
	    ans[x] = d[i];
	    if (priorityQ){
		ansPri[x] = pri[i];
	    }
	    x++;
	} 
	if (tail < head){
	    for (int i = 0; i <= tail; i++){
		ans[x] = d[i];
		if (priorityQ){
		    ansPri[x] = pri[i];
		}
		x++;
	    }
	}
	d = ans;
	if (priorityQ){
	    pri = ansPri;
	}
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

  
    //
    // priority queue methods
    //
    public void shrinkPri(){
	// resize array (half) and copy to new array
	Integer[] ans = new Integer[d.length/2];
	int x = 0;
	if (head < tail){
	    for (int i = head; i <= tail; i++){
		ans[x] = pri[i];
		x++;
	    }
	} else {
	    for (int i = head; i < d.length; i++){
		ans[x] = pri[i];
		x++;
	    } 
	    for (int i = 0; i <= tail; i++){
		ans[x] = pri[i];
		x++;
	    }
	}
	pri = ans;
	head = 0;
	tail = x-1;
    }

    public T removeLargest(){
	try {	    
	    if ((size <= d.length/4) && shrinkOn){
		shrink();
		shrinkPri();
	    }
	    size--;
	    Integer largestPri = pri[0];
	    int largestPriIndex = 0;
	    while (largestPri == null){
		largestPriIndex++;
		largestPri = pri[largestPriIndex];
	    }
	    for (int i = 1; i < d.length; i++){
		try {
		    if (pri[i] > largestPri){
			largestPriIndex = i;
			largestPri = pri[i];			
		    }
		} catch (NullPointerException e){
		    // do nothing
		}
	    }
	    T hold = (T)d[largestPriIndex];
	    d[largestPriIndex] = d[head];
	    pri[largestPriIndex] = pri[head];
	    d[head] = null;
	    pri[head] = null;	    
	    if (head >= d.length){
		head = 0;
	    } else {
		head++;
	    }
	    return hold;
	} catch (NoSuchElementException e){
	    throw new NoSuchElementException();
	}
    }

    public T removeSmallest(){
	try {	    
	    if ((size <= d.length/4) && shrinkOn){
		shrink();
		shrinkPri();
	    }
	    size--;
	    Integer smallestPri = pri[0];
	    int smallestPriIndex = 0;
	    while (smallestPri == null){
		if (smallestPriIndex == d.length-1){
		    smallestPriIndex = -1;
		}
		smallestPriIndex++;
		smallestPri = pri[smallestPriIndex];
	    }	    
	    for (int i = 1; i < d.length; i++){
		try {
		    if (pri[i] < smallestPri){
			smallestPriIndex = i;
			smallestPri = pri[i];			
		    }
		} catch (NullPointerException e){
		    // do nothing
		}
	    }
	    T hold = (T)d[smallestPriIndex];
	    d[smallestPriIndex] = d[head];
	    pri[smallestPriIndex] = pri[head];
	    d[head] = null;
	    pri[head] = null;	    
	    if (head >= d.length-1){
		head = 0;
	    } else {
		head++;
	    }
	    return hold;
	} catch (NoSuchElementException e){
	    throw new NoSuchElementException();
	}
    }

    public void add(T value, int priority){
	if (size == d.length){
	    grow();
	}
	addFirst(value);
	pri[head] = priority;
	if (head == 0){
	    head = d.length-1;
	} else {
	    head--;
	}
    }

    public String priToString(){
	if (debugPrint == true){
	    return Arrays.toString(pri);
	}
	String ans = "[" + d[head];
	if (head <= tail){
	    for (int i = head+1; i <= tail; i++){
		ans += ", " + pri[i];
	    }
	    ans += "]";
	    return ans;
	}
	int x = 0;
	for (int i = head+1; i <= pri.length; i++){
	    ans += ", " + pri[x];
	    x++;
	}
	for (int i = 0; i <= tail; i++){
	    ans += ", " + pri[x];
	    x++;
	}
	ans += "]";
	return ans;
    }

    public static void main(String[]args){	
	/*
	MyDeque<String> md = new MyDeque<String>();

	try {
	    if (Integer.parseInt(args[0]) == 1){
		md.debugPrint = false;
	    } 
	    if (Integer.parseInt(args[1]) == 1){
		md.shrinkOn = true;
	    }
	} catch (ArrayIndexOutOfBoundsException e){

	}
	*/

	/*	
	// Testing for priority MyDeque
	//
	md.add("apple 1",1);
	md.add("banana 0",0);
	md.add("carrot 6",6);
	md.add("dinosaur 3",3);
	md.add("emily 10",10);
	//	md.add("foot 4",4);
	System.out.println(md.toString()); // [apple, banana, carrot, dinosaur, emily]
	System.out.println(md.removeSmallest()); // banana
	System.out.println(md.toString()); // [apple, carrot, dinosaur, emily]	
	System.out.println(md.removeSmallest()); // apple
	System.out.println(md.toString()); // [carrot, dinosaur, emily]
	System.out.println(md.removeLargest()); // emily
	System.out.println(md.toString()); // [carrot, dinosaur]
	System.out.println(md.removeLargest()); // carrot
	System.out.println(md.toString()); // [dinosaur]
	*/

	/*	
	// Testing for REGULAR MyDeque
	//
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
	*/
	
    }
    
}
