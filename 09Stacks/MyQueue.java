import java.util.*;

public class MyQueue<T> {

    public MyLinkedList<T> queue;

    public MyQueue(){
	queue = new MyLinkedList<T>(new LNode<T>());
    }

    public MyQueue(T value){
	queue = new MyLinkedList<T>(new LNode<T>(value));
    }

    public boolean enqueue(T value){
	queue.add(queue.size,value);
	return true;
    }

    public T dequeue(){
	try {
	    T hold = queue.getHead().getValue();
	    queue.remove();
	    return T;
	} catch (NoSuchElementException e){
	    throw new NoSuchElementException();
	}
    }
    
}