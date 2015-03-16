public class LNode<T> {

    private T value;
    private LNode<T> next;

    public LNode(T v){
	setValue(v);
	setNext(null);
    }

    public LNode(T v, LNode<T> n){
	setValue(v);
	setNext(n);
    }

    public void setValue(T v){
	value = v;
    }

    public T getValue(){
	return value;
    }

    public void setNext(LNode<T> n){
	next = n;
    }

    public LNode<T> getNext(){
	return next;
    }

    public String toString(){
	return "[ " + value + " ] ";
    }

    public static void main(String[]args){
	LNode<Integer> l = new LNode<Integer>(6);

	LNode<Integer> x = new LNode<Integer>(3);

	System.out.println(l.toString());
	System.out.println(x.toString());

	l.setNext(x);

	System.out.println(l.getNext().toString());
    }

}
