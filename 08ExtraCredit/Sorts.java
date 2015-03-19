import java.util.*;

public class Sorts {
    public static int[] ary;
    public int len;

    public static Random r = new Random();

    public static int[] merge(int[] x, int[] y){
	int[] ans = new int[x.length + y.length];
	int xAt = 0;
	int yAt = 0;
	while (xAt < x.length && yAt < y.length){
	    if (x[xAt] < y[yAt]){
		ans[xAt + yAt] = x[xAt];
		xAt++;
	    } else {
		ans[xAt + yAt] = y[yAt];
		yAt++;
	    }
	}
	if (xAt >= x.length){
	    for (int i = yAt; i < y.length; i++){
		ans[i + x.length] = y[i];
	    }
	}
	if (yAt >= y.length){
	    for (int c = xAt; c < x.length; c++){
		ans[c + y.length] = x[c];
	    }
	}
	return ans;
    }

    public static int[] mergeSort(int[] x){
	if (x.length < 2){
	    return x;
	}
	int half = x.length/2;
	return merge(mergeSort(Arrays.copyOfRange(x,0,half)),mergeSort(Arrays.copyOfRange(x,half,x.length)));
    }

    public static String toString(int[] a){
	String ans = "[ " + a[0];
	for(int i = 1; i < a.length; i++){
	    ans += ", " + a[i];
	}
	ans += " ]";
	return ans;
    }

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
	/*
	// if dups is 0, list may have duplicates, else no duplicates
	int dups = 0;
	try {
	    dups = Integer.parseInt(args[0]);
	} catch (ArrayIndexOutOfBoundsException e){}
	
	int l = 10;
	int[] a = new int[l];
	

	if (dups == 0){
	    for (int i = 0; i < l; i++){
		int n = r.nextInt(10)+1;
		a[i] = n;
	    }
	} else {
	    for (int i = 0; i < l; i++){
		int n = r.nextInt(10)+1;
		if (!in(a,n)){
		    a[i] = n;
		} else {
		    i--;
		}
	    }
	}		
	//	}
	//	for (int ii = 0; ii <= 9; ii++) {
	//	    a[ii] = 9-ii;
	//	}

	Sorts qs = new Sorts(a,l);

	System.out.println(qs.toString());
	qs.quickSort();
	System.out.println(qs.toString());
	}*/

	/*
	int n = 400000000;
	int[] a = new int[n];
	Random r = new Random();

	for (int i = 0; i < n; i++){
	    a[i] = r.nextInt(20)+1;
	}	
	*/
    }
}
