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
	while (current.getNext() != null){
	    setCurrent(current.getNext());
	}
	current.getNext().setValue(value);
	return true;
    }
    //null pointer exception
    public void add(int index, int value){
	try {
	    while (index > 0){
		setCurrent(current.getNext());
		index--;
	    }
	    current.getNext().setValue(value);
	} catch (IndexOutOfBoundsException e){
	    throw new IndexOutOfBoundsException();
	}
    }
    
    public String toString(){
	String ans = "[ " + getCurrent().getValue();
	while (current.getNext() != null){
	    ans += ", " + current.getNext().getValue();
	}
	ans += " ]";
	return ans;
    }

    // remove(int index), size(), indexOf(int value)

    public static void main(String[]args){
	LNode ln = new LNode(5);
	LNode x = new LNode(8);
	MyLinkedList m = new MyLinkedList(ln);

	System.out.println(ln.toString());
	System.out.println(m.toString());
	m.add(1);
	System.out.println(m.toString());
    }

}