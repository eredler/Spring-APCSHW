import java.util.*;

public class Frontier {
    //keep track of where you've been
    public MyLinkedList mll = new MyLinkedList();

    public MyDeque dq = new MyDeque();

    public Frontier(){
	dq = new MyDeque(20);
    }

    public addCoor(Coordinate from, Coordinate to){
	
    }

    private boolean solve(boolean anim, int mode){
	// mode is DFS(1) or BFS(0)
    }

}