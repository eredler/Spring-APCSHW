import java.util.*;

public class NQueens {

    public String[][] board;

    public String name(){
	return "redler.emily";
    }

    public NQueens(int size){
	board = new String[size][size];
	for (int x = 0; x < size; x++){
	    for (int y = 0; y < size; y++){
		board[x][y] = "x";
	    }
	}
    }

    public String toString(){
	String ans = "";

	for (int n = 0; n < board.length; n++){
	    for (int i = 0; i < board[0].length; i++){
		ans += board[n][i] + " ";
	    }
	    ans += "\n";
	}

	return ans;
    }

    public boolean inLine(int row, int col){
	int size = board.length;
	int x, y, n;

	//left
	for (n = 0; n < col; n++){
	    if (board[row][n].equals("Q")){
		return false;
	    }
	}

	//up left
	for (x = row, y = col; x >= 0 && y >= 0; x--, y--){
	    if (board[x][y].equals("Q")){
		return false;
	    }
	}

	//down left
	for (x = row, y = col; x < size && y >= 0; x++, y--){
	    if (board[x][y].equals("Q")){
		return false;
	    }
	}
	   	
	return true;
    }

    public boolean solve(){
	return solve(0,0);
    }

    public boolean solve(int x){
	return solve(x,0);    
    }

    public boolean solve(int x, int y){

	if (y >= board.length){
	    System.out.println(this);
	    System.out.println("Done!");
	    return true;
	}

	for (int i = 0; i < board.length; i++){

	    if (inLine(i,y)){

		board[i][y] = "Q";	    

		if (solve(x,y+1)){
		    return true;
		}

		board[i][y] = "x";

	    }
	}

	return false;    
    }

    public static void main(String[]args){
	int size = 8;

	try {
	    size = Integer.parseInt(args[0]);
	} catch (Exception e){
	}

	NQueens nq = new NQueens(size);

	if (nq.solve() == false){
	    System.out.println("no solution");
	}
    }

}
