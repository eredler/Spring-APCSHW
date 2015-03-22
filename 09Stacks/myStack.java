import java.util.*;

public class myStack<T> {
    public LinkedList<T> stack;

    public myStack(){
	stack = new LinkedList<T>();
    }

    public T push(T item){
	stack.addFirst(item);
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
	    return stack.getFirst();
	} catch (EmptyStackException e){
	    throw new EmptyStackException();
	}
    }

    public static void main(String[]args){
	myStack<Integer> ms = new myStack<Integer>();

	System.out.println(ms.push(1)); // 1
	System.out.println(ms.push(-345)); // -345
	System.out.println(ms.push(0)); // 0
	System.out.println(ms.peek()); // 0
	System.out.println(ms.pop()); // 0
	System.out.println(ms.peek()); // -345
	
    }

}
