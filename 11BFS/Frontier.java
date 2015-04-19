import java.util.*;
import java.io.*;

public class Frontier<Coordinate> extends MyDeque{
    //keep track of where you've been

    public MyDeque<Coordinate> dq = new MyDeque<Coordinate>();

    private int Astar = 3;
    private int best = 2;
    private int DFS = 1;
    private int BFS = 0;

    private int mode;

    public int endx;
    public int endy;

    public Frontier(int m, Coordinate start, int ex, int ey){
	mode = m;
	dq = new MyDeque<Coordinate>();
	add(start);
	endx = ex;
	endy = ey;
    }

    public void add(Coordinate c){
	int cx = c.getX();
	int cy = c.getY();
	if (mode == DFS){
	    dq.addFirst(c);
	} else if (mode == BFS) {
	    dq.addLast(c);
	} else if (mode == best){
	    dq.add(c, Math.abs(endx-cx) + Math.abs(endy-cy)); 
	} else {
	    dq.add(c, Math.abs(endx-cx) + Math.abs(endy-cy) + c.getSteps());
	}
    }

    public boolean isEmpty(){
	return (dq.size==0);
    }
    
    public Coordinate remove(){
	if (mode == DFS || mode == BFS){
	    return dq.removeFirst();
	} else {
	    return dq.removeSmallest();
	}
    }

}
