import java.util.*;

public class MyLinkedList {

    private LNode head;
    private LNode current;

    public MyLinkedList(LNode h, LNode c){
	setHead(h);
	setCurrent(c);
    }

    public MyLinkedList(LNode h){
	setHead(h);
	setCurrent(h);
    }

    public void setHead(LNode h){
	head = h;
    }
    
    public LNode getHead(){
	return head;
    }

    public void setCurrent(LNode c){
	current = c;
    }

    public LNode getCurrent(){
	return current;
    }

    public int get(int index){
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

    public boolean add(int value){
	setCurrent(head);
	while (current.getNext() != null){
	    setCurrent(current.getNext());
	}
	current.setNext(new LNode(value));
	System.out.println("yo");
	return true;
    }

    public void add(int index, int value){
	try {
	    setCurrent(head);
	    while (index > 1){
		setCurrent(current.getNext());
		index--;
	    }
	    current.setNext(new LNode(value,current.getNext()));
	} catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }
    
    public String toString(){
	setCurrent(head);
	String ans = "[ " + getCurrent().getValue();
	while (current.getNext() != null){
	    ans += ", " + current.getNext().getValue();
	    setCurrent(current.getNext());
	}
	ans += " ]";
	return ans;
    }

    // remove(int index), size(), indexOf(int value)

    public int size(){
	setCurrent(head);
	int i = 0;
	while (current.getNext() != null){
	    i++;
	    setCurrent(current.getNext());
	}
	i++;
	return i;
    }
	
    public int remove(){
	try {
	    current = head.getNext();
	    int hold = head.getValue();
	    setHead(current);
	    return hold;
	} catch (NoSuchElementException e){
	    throw new NoSuchElementException();
	}
    }

    public int remove(int index){
	try {
	    setCurrent(head);
	    while (index > 1){
		setCurrent(current.getNext());
		index--;
	    }
	    //fix
	    current.setNext(current.getNext().getNext().getValue());
	} catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }

    public static void main(String[]args){
	LNode ln = new LNode(5);
	MyLinkedList m = new MyLinkedList(ln);

	System.out.println(ln.toString());
	System.out.println(m.toString());
	m.add(1);
	System.out.println(m.toString());
	System.out.println(m.size());
	m.add(1,8);
	System.out.println(m.toString());
	System.out.println(m.size());
	System.out.println(m.remove());
	System.out.println(m.toString());
    }

}