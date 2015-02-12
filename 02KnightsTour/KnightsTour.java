import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";

	//build your knights tour here...
	for (int i = 0; i < board.length; i++) {
	    for (int c = 0; c < board.length; c++){
		ans += "x ";//board[i][c];
	    }
	    ans += "\n";
	}

	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	board = new int[size][size];

	for (int i = 0; i < board.length; i++) {
	    for (int c = 0; c < board.length; c++){
		board[i][c] = -1;
	    }
	}
    }

    

    public void solve(){
	solve(0,0,0);
    }


    public void solve(int startx, int starty){
	solve(startx,starty,0);
    }



		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);

	if (x >= board.length || y >= board[0].length) {
	    return false;
	}
			
	if (board[x][y] != -1){
	    return false;
	}

	/* if (////check if solved////) {
	    return true;
	    }*/

	if (solve(x+2,y+1,currentMoveNumber+1) ||
	    solve(x+2,y-1,currentMoveNumber+1) || 
	    solve(x-1,y-2,currentMoveNumber+1) || 
	    solve(x-1,y+2,currentMoveNumber+1) ||
	    solve(x-2,y-1,currentMoveNumber+1) || 
	    solve(x-2,y+1,currentMoveNumber+1) || 
	    solve(x+1,y-2,currentMoveNumber+1) || 
	    solve(x+1,y+2,currentMoveNumber+1) ) {

	    board[x][y] = currentMoveNumber;

	    return true;

	}
	System.out.println(clear);
	return false;
    }

    public static void main(String[]args){

	    int size = Integer.parseInt(args[0]);
	    if (size < 1) {
		System.out.println("Please call the KnightsTour with an integer size greater than 0.");
	    } else {

	    KnightsTour kt = new KnightsTour(size);

	    System.out.println(kt.solve(0,0,0));
	    }
    }



}