import java.util.*;

public class Frontier<Coordinate> extends MyDeque{
    //keep track of where you've been

    public MyDeque<Coordinate> dq = new MyDeque<Coordinate>();
    private int DFS = 1;
    private int BFS = 0;
    private int mode;

    public Frontier(int m){
	mode = m;
	dq = new MyDeque<Coordinate>();
    }

    public void add(Coordinate c){
	if (mode == DFS){
	    dq.addFirst(c);
	} else {
	    dq.addLast(c);
	}
    }

    public boolean isEmpty(){
	return (dq.size==0);
    }
    
    public Coordinate remove(){
	return dq.removeFirst();
    }

}
