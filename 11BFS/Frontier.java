import java.util.*;

public class Frontier extends MyDeque{
    //keep track of where you've been

    public MyDeque dq = new MyDeque();

    public Frontier(){
	dq = new MyDeque(20);
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