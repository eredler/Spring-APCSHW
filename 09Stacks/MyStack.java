import java.util.*;

public class MyStack<T> {
    public MyLinkedList<T> stack;

    public MyStack(T value){
	stack = new MyLinkedList<T>(new LNode<T>(value));
    }

    public T push(T item){
	stack.add(item);
	return item;
    }

    public T pop(){
	try{
	    return stack.remove();
	} catch (EmptyStackException e){
	    throw new EmptyStackException();
	}
    }

    public T peek(){
	try {
	    return stack.getHead().getValue();
	} catch (EmptyStackException e){
	    throw new EmptyStackException();
	}
    }

    public static void main(String[]args){
	MyStack<Integer> ms = new MyStack<Integer>(8);

	System.out.println(ms.push(1)); // 1
	System.out.println(ms.push(-345)); // -345
	System.out.println(ms.push(0)); // 0
	System.out.println(ms.peek()); // 0
	System.out.println(ms.pop()); // 0
	System.out.println(ms.peek()); // -345
	
    }

}
