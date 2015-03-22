import java.util.*;

public class MyLinkedList<T> implements Iterable<T> {

    private LNode<T> head;
    private LNode<T> current;
    private LNode<T> tail;

    public int size = 1;

 //
    // INTERNAL ITERATOR CLASS
    //
    public class MLLIterator implements Iterator<T> {
	public LNode<T> now;

	// constructor
	public MLLIterator(LNode<T> head){
	    now = head;
	}
	
	public boolean hasNext(){
	    if (now.getNext() == null){
		return false;
	    }
	    return true;
	}

	public T next(){
	    if (hasNext()){	
		T ans = now.getValue();
		now = now.getNext();
		return ans;
	    } else {
		throw new NoSuchElementException();
	    }
	}

	// optional so throw exception
	public void remove(){
	    throw new UnsupportedOperationException();
	}

    }


    public MyLinkedList(LNode<T> h, LNode<T> c){
	setHead(h);
	setCurrent(c);
	while (current.getNext() != null){
	    setCurrent(current.getNext());
	}
	setTail();
	setCurrent(c);
    }

    public MyLinkedList(LNode<T> h){
	setHead(h);
	setCurrent(h);
	while (current.getNext() != null){
	    setCurrent(current.getNext());
	}
	setTail();
	setCurrent(h);
    }

    public String name(){
	return "redler.emily";
    }

    public void setHead(LNode<T> h){
	head = h;
    }
    
    public LNode<T> getHead(){
	return head;
    }

    public void setCurrent(LNode<T> c){
	current = c;
    }

    public LNode<T> getCurrent(){
	return current;
    }

    public void setTail(){
	while (current.getNext() != null){
	    setCurrent(current.getNext());
	}
	setTail(current);
    }

    public void setTail(LNode<T> t){
	tail = t;
    }

    public LNode<T> getTail(){
	return tail;
    }

    public T get(int index){
	setCurrent(head);
	try{
	    while (index > 0){
		setCurrent(current.getNext());
		index--;
	    }
	    return current.getValue();
	} catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }

    public boolean add(T value){
	add(size,value);
	return true;
    }

    public void add(int index, T value){
	try {
	    setCurrent(head);
	    while (index > 1){
		setCurrent(current.getNext());
		index--;
	    }
	    current.setNext(new LNode<T>(value,current.getNext()));
	    size++;
	} catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }
    
    public String toString(){
	setCurrent(head);
	String ans = "[ " + current.getValue();
	if (head.getNext() != null){
	    setCurrent(current.getNext());
	    while (current.getNext() != null){
		ans += ", " + current.getValue();
		setCurrent(current.getNext());
	    }
	    ans += ", " + current.getValue();
	}
	ans += " ]";
	return ans;
    }

    public int indexOf(T value){
	int i = 0;
	while (current.getNext().getValue() != value){
	    if (current.getNext().getNext() == null && current.getValue() != value){
		return -1;
	    }
	    i++;
	    setCurrent(current.getNext());
	}
	return i;
    }

    public int size(){
	return size;
    }
	
    public T remove(){
	try {
	    current = head.getNext();
	    T hold = head.getValue();
	    setHead(current);
	    return hold;
	} catch (NoSuchElementException e){
	    throw new NoSuchElementException();
	}
    }

    public T remove(int index){
	try {
	    setCurrent(head);
	    while (index > 1){
		setCurrent(current.getNext());
		index--;
	    }
	    T hold = current.getNext().getValue();
	    current.getNext().setNext(current.getNext().getNext());
	    size--;
	    return hold;
	} catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }

   
    // since MyLinkedList implememts Iterable, has to declare iterator()
    public Iterator<T> iterator(){
	return new MLLIterator(head);
    }

    public static void main(String[]args){
	LNode<Integer> ln = new LNode<Integer>(5);
	MyLinkedList<Integer> m = new MyLinkedList<Integer>(ln);

	System.out.println(ln.toString()); // [ 5 ]
	System.out.println(m.toString()); // [ 5 ] 
	m.add(1); 
	System.out.println(m.toString()); // [ 5, 1 ]
	System.out.println(m.size()); // 2
	m.add(1,8);
	System.out.println(m.toString()); // [ 5, 8, 1 ]
	System.out.println(m.size()); // 3
	System.out.println(m.remove()); // 5
	System.out.println(m.toString()); // [ 8, 1 ]
    }

}
