import java.util.*;

public class Frontier<Coordinate> extends MyDeque{
    //keep track of where you've been

    public MyDeque<Coordinate> dq = new MyDeque<Coordinate>();

    public Frontier(){
	dq = new MyDeque<Coordinate>(20);
    }

    /* private boolean solve(boolean anim, int mode){
	
       }*/

    //BFS methods

    /*   public void addFirst(Coordinate c){
	dq.addFirst(c);
    } 

    public void addLast(Coordinate c){
	dq.addLast(c);
    } 

    public Coordinate getFirst(){
	return dq.getFirst();
	}*/

}