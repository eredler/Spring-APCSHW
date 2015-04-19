import java.util.*;
import java.io.*;

//
// test with http://qiao.github.io/PathFinding.js/visual/
//

public class Maze {

    public char maze[][];

    private static final String clear = "\033[2J";
    private static final String hide = "\033[?25l";
    private static final String show = "\033[?25h";

    private static final int Astar = 3;
    private static final int best = 2;
    private static final int DFS = 1; // mode of 
    private static final int BFS = 0; // solving

    private int startx;
    private int starty;

    public ArrayList<Coordinate> solution;
    
    public Coordinate start = new Coordinate(0,0);
    public Coordinate end = new Coordinate(0,0);

    public int[] solutionCoordinates = new int[1];

    public int maxx = 0;
    public int maxy = 0;

    public boolean printNice = false;

    public static final char WALL = '#';
    public static final char FRONTIER = '*';
    public static final char PATH = '.';

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

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

	startx = -1;
	starty = -1;
	String ans = "";

	try {
	    File f = new File(filename);

	    Scanner in = new Scanner(f);
	    
	    while (in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    maxx = line.length();
		}
		maxy++;
		ans += line;
	    }
	} catch (Exception e){
	    System.out.println("File fot found.");
	    System.exit(0);
	}

	maze = new char[maxy][maxx];
	int i = 0;
	for (int y = 0; y < maxy; y++){
	    for (int x = 0; x < maxx; x++){
		maze[y][x] = ans.charAt(i);
		i++;
		if (maze[y][x] == 'S'){
		    start.setX(x);
		    start.setY(y);
		} else if (maze[y][x] == 'E'){
		    end.setX(x);
		    end.setY(y);
		}
	    }
	}

    }

    //do not do the funky character codes
    public String toString(){
	String ans = "";
	for (int y = 0; y < maxy; y++){
	    for (int x = 0; x < maxx; x++){
		if (maze[y][x] == '#'){
		    ans +=/* color(38,47) + */maze[y][x] + " ";
		} else {
		    ans +=/* color(32,40) + */maze[y][x] + " ";
		}
		//	sop(ans);
	    }
	    ans += "\n";
	}
	return ans;
    }

    //do the funky character codes when animate is true
    public String toString(boolean animate){
	if (animate) {
	    return hide+clear+go(0,0)+toString()+show;//+color(37,40);
	} 
	return this.toString();
    }

    public boolean inRange(int x, int y){
	return ! (x < 0 || y < 0 || x >= maxx || y >= maxy);
    }

    public boolean goodSpot(int x, int y){
	return !(maze[y][x] == WALL || maze[y][x] == FRONTIER);
    }

    public void clearRest(){
	for (int y = 0; y < maxy; y++){
	    for (int x = 0; x < maxx; x++){
		if (!(maze[y][x] == 'E' || 
		      maze[y][x] == WALL || 
		      maze[y][x] == PATH ||
		      maze[y][x] == 'S')){
		    maze[y][x] = ' ';
		}
	    }
	}
    }

    public boolean solve(int mode, boolean animate){
	//	System.out.println(start.toString()+"YYYYYYYYYYYYYYYYYY");
	Frontier<Coordinate> frontier = new Frontier<Coordinate>(mode,start,end.getX(),end.getY());
	
	solution = new ArrayList<Coordinate>();

	while (frontier.isEmpty() == false){
	    
	    if (animate){
		wait(20);
		System.out.println(toString(animate));
	    }
	    //	    System.out.println(frontier.toString());
	    Coordinate current = frontier.remove();
	    
	    int x = current.getX();
	    int y = current.getY();
	    
	    if (inRange(x,y) && goodSpot(x,y)){
		if (maze[y][x] == 'E'){
		    end = current;
		    Coordinate solnPath = end.getPrev();
		    
		    while (solnPath.getPrev() != null){
			maze[solnPath.getY()][solnPath.getX()] = PATH;
			solution.add(solnPath);
			solnPath = solnPath.getPrev();
		    }
		    maze[solnPath.getY()][solnPath.getX()] = 'S';
		    clearRest();
		    if (animate){
			System.out.println(toString(false));
		    } else {
			System.out.println(toString(true));
		    }
		    if (!printNice){
			String ans = "[ " + solution.get(0).getX() + ", " + solution.get(0).getY();
			for (int i = 1; i < solution.size(); i++){
			    ans += ", " + solution.get(i).getX() + ", " + solution.get(i).getY();
			}
			ans += " ]"; 
			System.out.println(ans);
		    } else {
			System.out.println(solution.toString());
		    }
		    return true;
		
		}
		
		maze[y][x] = FRONTIER;
		
		Coordinate lessX = new Coordinate(x-1,y);
		Coordinate lessY = new Coordinate(x,y-1);
		Coordinate moreX = new Coordinate(x+1,y);
		Coordinate moreY = new Coordinate(x,y+1);

		lessX.setPrev(current);
		lessY.setPrev(current);
		moreX.setPrev(current);
		moreY.setPrev(current);

		if (mode == Astar){
		    lessX.setSteps(current.getSteps()+1);
		    lessY.setSteps(current.getSteps()+1);
		    moreX.setSteps(current.getSteps()+1);
		    moreY.setSteps(current.getSteps()+1);
		}

		frontier.add(lessX);
		frontier.add(lessY);
		frontier.add(moreX);
		frontier.add(moreY);

		
		//	    System.out.println(frontier.getFirst().toString());
	    }

	}

	System.out.println("No solution.");
	return false;
    }

    /*Solve the maze using a frontier in a DFS manner.
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze.
     */

    
    public boolean solveBFS(boolean animate){
	return solve(BFS,animate);
    }

    public boolean solveDFS(boolean animate){
	return solve(DFS,animate);
    }

    public boolean solveBest(boolean animate){
	return solve(best,animate);
    }
    
    public boolean solveAStar(boolean animate){
	    return solve(Astar,animate);
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

    public boolean solveBest(){
	return solveBest(false);
    }

    public boolean solveAStar(){
	return solveAStar(false);
    }

    /*return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition : solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
     *Postcondition: the correct solution is in the returned array
     */

    public static void main(String[]args){
	String f = "no file";
	int mode = 0;
	boolean anim = false;

	try {
	    f = args[0];
	    mode = Integer.parseInt(args[1]);
	    if (mode != 0 && mode != 1){
		System.out.println("Mode not recognized (must be 0 for BFS, 1 for DFS, 2 for best first, or 3 for A*).");
	    }
	    if (Integer.parseInt(args[2]) == 0){
		anim = true;
	    }
	} catch (Exception e){
	    System.out.println("Gimme a (VALID!) file, mode (0 for BFS, 1 for DFS, 2 for best first, or 3 for A*) and animate status (0 for animate, 1 for don't)!!!");
	    System.exit(0);
	}

	Maze m = new Maze(f);
	System.out.println(m.toString());
	m.solve(mode, anim);
    }

}
