import java.util.*;
import java.io.*;

public class cTravel {

    char[][] field;
    int numWays = 0;
    int T, R1, C1, R2, C2, M, N;

    public int parseFileForVolume(String filename) {
	File file;
	Scanner read;
	try {
	    file = new File("ctravel.in");
	    read = new Scanner(file);
	} catch (Exception e) {
	    throw new Error("File not found.");
	}
	ArrayList<String> lines = new ArrayList<String>();
	while (read.hasNextLine()) {
	    String line = read.nextLine();
	    lines.add(line.toUpperCase());
	}
	String[] data = lines.get(0).split(" ");
	N = Integer.parseInt(data[0]);
	M = Integer.parseInt(data[1]);
	T = Integer.parseInt(data[2]);
	field = new char[N][M];
	for (int i = 0; i < N; ++i) {
	    String line = lines.get(1 + i);
	    for (int j = 0; j < M; ++j) {
		field[i][j] = line.charAt(i*M + j);
	    }
	}
	String[] L = lines.get(N+1).split(" ");
	R1 = Integer.parseInt(L[0]);
	C1 = Integer.parseInt(L[1]);
	R2 = Integer.parseInt(L[2]);
	C2 = Integer.parseInt(L[3]);
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i < field.length; i++){
	    for(int n = 0; n < field[i].length; n++){
		ans += field[i][n];
	    }
	    ans += "\n";
	}
    }

    public cTravel(int n, int m){
	field = new char[n][m];
    }

    public boolean travel(int time, int currR, int currC){

	if (field[currR][currC].equals("*")){
	    return false;
	}

	if (time > T){
	    return false;
	}

	if (currR == R2 && currC == C2 && time == T){
	    numWays++;
	    return true;
	}
	
	if (travel(time+1,currR+1,currC) || travel(time+1,currR,currC+1) ||
	    travel(time+1,currR-1,currC) || travel(time+1,currR,currC-1)) {
	    return true;
	}
    }


}