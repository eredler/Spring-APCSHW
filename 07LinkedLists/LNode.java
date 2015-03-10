public class LNode {

    private int value;
    private LNode next;

    public LNode(int v){
	setValue(v);
    }

    public LNode(int v, LNode n){
	setValue(v);
	setNext(n);
    }

    public void setValue(int v){
	value = v;
    }

    public int getValue(){
	return value;
    }

    public void setNext(LNode n){
	next = n;
    }

    public LNode getNext(){
	return next;
    }

    public String toString(){
	return "[ " + value + " ] ";
    }

    public static void main(String[]args){
	LNode l = new LNode(6);

	LNode x = new LNode(3);

	System.out.println(l.toString());
	System.out.println(x.toString());

	l.setNext(x);

	System.out.println(l.getNext().toString());
    }

}
