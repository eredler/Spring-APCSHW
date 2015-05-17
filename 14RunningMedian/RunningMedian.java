public class RunningMedian{

    final static boolean MAX_HEAP = true;
    final static boolean MIN_HEAP = false;

    MyHeap max;
    MyHeap min;
    
    public ArrayList<int> median;
 
    public RunningMedian(){
	max = new MyHeap(MAX_HEAP);
	min = new MyHeap(MIN_HEAP);
	median = new ArrayList<int>();
    }

    public findMedian(){
	if (median.size() == 0){
	    return (max.peek() + min.peek()) /2;
	} else {
	    return median.get(0);
	}
    }

    public void add(int v){
	if (max.size < 1 || min.size < 1){
	    median.set(0,v);
	} else {
	    if (median.size() < 1){
		if (v < max.peek()){
		    max.add(v);
		    median.set(0,max.remove());
		} else {
		    min.add(v);
		    median.set(0,min.remove());
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

    public String name {
	return "Redler, Emily";
    }

    public String toString(){
	return getMedian().toString();
    }

    public static void main(String[]args){
	RunningMedian r = new RunningMedian();
	
	r.add(3);
	r.add(8);
	r.add(2);
	System.out.println(r.toString());
	
    }

}
