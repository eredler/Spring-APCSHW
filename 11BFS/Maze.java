import java.util.*;
import java.io.*;

public class Maze {

    public char maze[][];

    private static final String clear = "\033[2J";
    private static final String hide = "\033[?25l";
    private static final String show = "\033[?25h";

    private static final int DFS = 1; // mode of 
    private static final int BFS = 0; // solving

    public Coordinate start = new Coordinate(0,0);
    public Coordinate end = new Coordinate(0,0);

    public MyDeque<Coordinate> frontier = new MyDeque<Coordinate>();

    public int numCols = 0;
    public int numRows = 0;

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public void sop(String o) {
	System.out.println(o);
    }

    public void sop(int o) {
	System.out.println(o);
    }

    public Maze(String filename){
	// set start coordinate
	// set end coordinate

	String ans = "";

	try {
	    File f = new File(filename);

	    Scanner in = new Scanner(f);
	    
	    while (in.hasNext()){
		String line = in.nextLine();
		if(numRows == 0){
		    numCols = line.length();
		}
		numRows++;
		ans += line;
	    }

	    maze = new char[numRows][numCols];
	    int x = 0;
	    for (int r = 0; r < numRows; r++){
		for (int c = 0; c < numCols; c++){
		    maze[r][c] = ans.charAt(x);
		    x++;
		}
	    }
	    boolean foundS = false;
	    boolean foundE = false;
	
	    while (foundS == false){
		outer:
		for (int r = 0; r < numRows; r++){
		    for (int c = 0; c < numCols; c++){
			if (maze[r][c] == 'S'){
			    start = new Coordinate(c,r);
			    foundS = true;
			    break outer;
			}
		    }
		}
	    }

	    while (foundE == false){
		outer:
		for (int r = 0; r < numRows; r++){
		    for (int c = 0; c < numCols; c++){
			if (maze[r][c] == 'E'){
			    end = new Coordinate(c,r);
			    foundE = true;
			    break outer;
			}
		    }
		}
	    }

	    frontier.addFirst(start);
	} catch (FileNotFoundException e){
	    System.out.println("ERROR: Cannot run [1]");
	    //	    throw new FileNotFoundException();
	}
    }

    //do not do the funky character codes
    public String toString(){
	String ans = "";
	for (int r = 0; r < numRows; r++){
	    for (int c = 0; c < numCols; c++){
		ans += maze[r][c] + " ";
		sop(ans);
	    }
	    ans += "\n";
	}
	return ans + "\n";
    }

    //do the funky character codes when animate is true
    public String toString(boolean animate){
	//
	// animate later
	//
	return this.toString();
    }

    public boolean solveBFS(boolean animate){
	//	frontier.solve(animate,0);
	Coordinate current = frontier.getLast();
	sop("current " + current.toString());
	while (frontier.getFirst() != end){
	    boolean xisnotmin = current.getX() > 0;
	    boolean xisnotmax = current.getX() < numCols - 1;
	    boolean yisnotmin = current.getY() > 0;
	    boolean yisnotmax = current.getY() < numRows - 1;

	    boolean addedSomething = false;
	    //   System.out.println(current.toString());
	    //	    System.out.println("yismax " + yismax);
	    // System.out.println("yismin " + yismin);
	    // System.out.println("xismax " + xismax);
	    // System.out.println("xismin " + xismin);
	    //	    System.out.println("[" + maze[current.getY()+1][current.getX()] + "]" + " current.getY()+1");
	    //    System.out.println(maze[current.getY()-1][current.getX()] + " current.getY()-1");
	    //	    System.out.println(maze[current.getY()][current.getX()+1] + " current.getX()+1");
	    //	    System.out.println(maze[current.getY()][current.getX()-1] + " current.getX()-1");
	    //  sop("a");
	    if (yisnotmax && maze[current.getY()+1][current.getX()] == ' '){
		//	sop("hi");
		//	System.out.println(frontier.toString());
		frontier.addFirst(new Coordinate(current.getX(),current.getY()+1));
		frontier.getFirst().setPrev(current);
		addedSomething = true;
		System.out.println(frontier.getFirst().toString());
	    }
	    //    sop("b");
	    if (yisnotmin && maze[current.getY()-1][current.getX()] == ' '){

		System.out.println(frontier.toString());
		frontier.addFirst(new Coordinate(current.getX(),current.getY()-1));
		frontier.getFirst().setPrev(current);
		addedSomething = true;
	    }
	    //   sop("c");
	    if (xisnotmin && maze[current.getY()][current.getX()-1] == ' '){

		System.out.println(frontier.toString());
		frontier.addFirst(new Coordinate(current.getX()-1,current.getY()));
		frontier.getFirst().setPrev(current);
		addedSomething = true;
	    }
	    //   sop("d");
	    if (xisnotmax && maze[current.getY()][current.getX()+1] == ' '){

		System.out.println(frontier.toString());
		frontier.addFirst(new Coordinate(current.getX()+1,current.getY()));
		frontier.getFirst().setPrev(current);
		addedSomething = true;
	    }
	    //   sop("e");
	    frontier.removeLast();
	    sop(frontier.getLast().toString());
	    //   sop("f");
	    try {
		current = frontier.getLast();
	    } catch (ArrayIndexOutOfBoundsException e){
		System.out.println("exception");
		return false;
	    }
	}
	while (current.getPrev() != null){
	    maze[current.getY()][current.getX()] = '.';
	}
	sop(this.toString());
	return true;
    }

    /*Solve the maze using a frontier in a DFS manner.
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze.
     */
    public boolean solveDFS(boolean animate){
	//	frontier.solve(animate,1);
	return true;
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    /*return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition : solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
     *Postcondition: the correct solution is in the returned array
     */
    public int[] solutionCoordinates(){
	return new int[1];
    }


    public static void main(String[]args){
	//	try {
	    Maze m = new Maze("test1.txt");
	    System.out.println(m.toString());
	    m.solveBFS();
	    //	} catch (FileNotFoundException e){
	    //System.out.println("ERROR: Cannot run [2]");

	    // throw new FileNotFoundException();
	    //	}
    }

}
