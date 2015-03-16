import java.util.*;

public class Sorts {
    public static int[] ary;
    public int len;

    public static Random r = new Random();

    public Sorts(int[] a, int l){
	ary = a;
	len = l;
    }

    public String name(){
	return "redler.emily";
    }

    public int getLen(){
	return len;
    }

    public static int inPlace(int si, int ei){

	int li = si;
	int ri = ei;
	int hold;
	int index = r.nextInt(1 - si + ei) + si;	
	int pivot = ary[index];
	//	System.out.println(Arrays.toString(ary));
	//	System.out.println("pivot: " + pivot);

	while (li <= ri && si != ei){

	    if (ary[li] < pivot){
		//	System.out.println(ary[li] + " < " + pivot);

		hold = ary[li];
		ary[li] = ary[si];
		ary[si] = hold;
		si++;

		if (hold == pivot){
		    index = si;
		} else if (ary[li] == pivot){
		    index = li;
		}

		li++;
		//		System.out.println(Arrays.toString(ary));

	    } else if (ary[li] > pivot){
		hold = ary[li];
		//	System.out.println(ary[li] + " > " + pivot);
		ary[li] = ary[ei];
		ary[ei] = hold;
		ei--;
		//		System.out.println(Arrays.toString(ary));
	
		if (hold == pivot){
		    index = si;
		} else if (ary[li] == pivot){
		    index = li;
		}

	    } else {
		li++;
	    }
	}

    hold = ary[si];
    ary[si] = pivot;
    ary[index] = hold;
    return index;
    }

    //for making list with no duplicates for testing
    public static boolean in(int[] a, int e){
	for (int i = 0; i < a.length; i++){
	    if (a[i] == e){
		return true;
	    }
	}
	return false;
    }

    public String toString(){
	return Arrays.toString(ary);
    }

    //doesn't deal with duplicates
    public static void quickSort(){
	quickSort(0,ary.length-1);
    }

    public static void quickSort(int si, int ei){
	if (si < ei){
	    int index = inPlace(si, ei);
	    quickSort(si, index-1);
	    quickSort(index+1, ei);
	}
    }
    
    public static void main(String[]args){
	int l = 10;
	int[] a = new int[l];

	for (int i = 0; i < l; i++){
	    int n = r.nextInt(10)+1;
	    //    if (!in(a,n)){
		a[i] = n;
		//    } else {
		//		i--;
		
		//	    }
	}
	//	for (int ii = 0; ii <= 9; ii++) {
	//	    a[ii] = 9-ii;
	//	}

	Sorts qs = new Sorts(a,l);

	System.out.println(qs.toString());
	qs.quickSort();
	System.out.println(qs.toString());
    }


}
