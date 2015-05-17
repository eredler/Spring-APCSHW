import java.util.*;

public class RunningMedian{

    final static boolean MAX_HEAP = true;
    final static boolean MIN_HEAP = false;

    MyHeap max;
    MyHeap min;
    
    public ArrayList<Integer> median;
 
    public RunningMedian(){
	max = new MyHeap(MAX_HEAP);
	min = new MyHeap(MIN_HEAP);
	median = new ArrayList<Integer>();
    }

    public int findMedian(){
	if (median.size() == 0){
	    return (max.peek() + min.peek()) /2;
	} else {
	    return median.get(0);
	}
    }

    public void add(int v){
	if (max.size < 1 && min.size < 1 && median.size() < 1){
	    median.add(v);
	} else {
	    if (median.size() < 1){
		if (v < max.peek()){
		    max.add(v);
		    median.add(max.remove());
		} else {
		    min.add(v);
		    median.add(min.remove());
		}
	    } else {
		if (median.get(0) > v){
		    min.add(median.remove(0));
		    max.add(v);
		} else {
		    max.add(median.remove(0));
		    min.add(v);
		}
	    }
	}
    }

    public String name() {
	return "Redler, Emily";
    }

    public String toString(){
	String ans = "";
	ans += findMedian();
	return ans;
    }

    public String debug(){
	return "Max: " + max.toString() + "\n" + "Median: " + median.toString() + "\n" + "Min: " + min.toString();
    }

    public static void main(String[]args){
	RunningMedian r = new RunningMedian();
	
	r.add(4);
	r.add(8);
	r.add(2);
	r.add(7);
	r.add(5);
	System.out.println(r.toString());
	System.out.println(r.debug());
	
    }

}
