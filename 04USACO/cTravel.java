import java.util.*;
import java.io.*;

public class cTravel {

    private char[][] Xfield;
    private int XnumWays;
    private int Xtime;
    private int[] Xstart;
    private int[] Xend;

    private cTravel(char[][] field, int time, int[] start, int[] end){
	setUp(field, time, start, end);
	XnumWays = 0;
    }

    public void setUp(char[][] field, int time, int[] start, int[] end){
	Xfield = field;
	Xtime = time;
	Xstart = start;
	Xend = end;
	XnumWays = 0;
    }
   
    public static int parseFile(String filename) {
	File file;
	Scanner read;

	try {
	    file = new File(filename);
	    read = new Scanner(file);
	} catch (Exception ex) {
	    throw new Error("File not found.");
	}

	ArrayList<String> lines = new ArrayList<String>();

	while (read.hasNextLine()) {
	    String line = read.nextLine();
	    lines.add(line.toUpperCase());
	}

	String[] data = lines.get(0).split(" ");
	int N = Integer.parseInt(data[0]);
	int M = Integer.parseInt(data[1]);
	int T = Integer.parseInt(data[2]);
	char[][] field = new char[N][M];

	for (int i = 0; i < N; ++i) {
	    String line = lines.get(i + 1);

	    for (int j = 0; j < M; ++j) {
		field[i][j] = line.charAt(j);
	    }

	}

	String[] L = lines.get(N+1).split(" ");

	int[] start = new int[] {
	    Integer.parseInt(L[0]) - 1, Integer.parseInt(L[1]) - 1
	};

	int[] end = new int[] {
	    Integer.parseInt(L[2]) - 1, Integer.parseInt(L[3]) - 1
	};
	
	cTravel ct = new cTravel(field,T,start,end);

	return ct.solve();

    }

    public int solve(){
	solve(Xstart,Xend,Xtime);
	return XnumWays;
    }

    public void solve(int[] s, int[] e, int t){

	try {
	    if (t == 0 && s[0] == e[0] && s[1] == e[1]){
		XnumWays++;
		return;
	    }
	    if (Xfield[s[0]][s[1]] == '*' || t == 0){
		return;
	    }
	    int[] up = new int[] {
		s[0], s[1] - 1
	    };
	    int[] down = new int[] {
		s[0], s[1] + 1
	    };
	    int[] left = new int[] {
		s[0] - 1, s[1]
	    };
	    int[] right = new int[] {
		s[0] + 1, s[1]
	    };
	    solve(up, e, t-1);
	    solve(down, e, t-1);
	    solve(left, e, t-1);
	    solve(right, e, t-1);
	} catch (Exception ex) {}

    }

    public static void main(String[]args){
	System.out.println(cTravel.parseFile(args[0]));
    }
}
