import java.util.*;

public class Maze {

    private static final String clear = "\033[2J";
    private static final String hide = "\033[?25l";
    private static final String show = "\033[?25h";

    private static final int DFS = 1; // mode of 
    private static final int BFS = 0; // solving

    public Coordinate start = new Coordinate(0,0);
    public Coordinate end = new Coordinate(0,0);

    public Frontier frontier = new Frontier();

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    // Same constructor as before...
    public Maze(String filename){
	// set start coordinate
	// set end coordinate

	//get maze from file and turn into (2D array???)
	frontier.addFirst(start);
    }

    public String toString(){
	
    }//do not do the funky character codes

    public String toString(boolean animate){

    } //do the funky character codes when animate is true

    public boolean solveBFS(boolean animate){

    }

    /*Solve the maze using a frontier in a DFS manner.
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze.
     */
    public boolean solveDFS(boolean animate){

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
	
    }

}