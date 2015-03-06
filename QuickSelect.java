import java.util.*;

public class QuickSelect {

    public static Random r = new Random();

    public static void partition(int[] ary, int si, int ei){
	int[] d = new int[ary.length];
	int li = si;
	int ri = ei-1;
	
	for (int i = 0; i < si; i++){
	    d[i] = ary[i];
	}
	for (int c = ei; c < ary.length; c++){
	    d[c] = ary[c];
	}
	System.out.println(toString(d));
	int pivot = ary[r.nextInt(ei-si) + si];
	System.out.println(pivot);
	
	for (int x = si; x < ei; x++){
	    if (ary[x] == pivot){
	    } else if (ary[x] < pivot){
		d[li] = ary[x];
		System.out.println("d[li] " + d[li] + " li: " + li);
		li++;
		System.out.println(toString(d));
	    } else {
		d[ri] = ary[x];
		System.out.println("d[ri]: " + d[ri] + " ri: " + ri);
		System.out.println(toString(d));
		ri--;
	    }
	}
	
	d[ri] = pivot;
	System.out.println(toString(d));
    }

    public static String toString(int[] a){
	String ans = "[ " + a[0];
	for (int i = 1; i < a.length; i++){
	    ans += ", " + a[i];
	}
	ans += " ]";
	return ans;
    }

    public static boolean in(int[] a, int e){
	for (int i = 0; i < a.length; i++){
	    if (a[i] == e){
		return true;
	    }
	}
	return false;
    }


    public static void main(String[]args){
	int l = 10;
	int[] a = new int[l];

	for (int i = 0; i < l; i++){
	    int n = r.nextInt(100)+1;
	    if (!in(a,n)){
		a[i] = n;
	    } else {
		i--;
	    }
	}

	System.out.println(toString(a));
	partition(a,0,l);
	//	System.out.println(toString(a));
    }


}
