import java.util.*;

public class QuickSelect {
    int[] ary;
    int len;

    public static Random r = new Random();

    public QuickSelect(int[] a, int l){
	ary = a;
	len = l;
    }

    public int getLen(){
	return len;
    }

    public int partition(int n, int si, int ei){
	int[] d = new int[ary.length];
	int li = si;
	int ri = ei-1;
	
	for (int i = 0; i < si; i++){
	    d[i] = ary[i];
	}
	for (int c = ei; c < ary.length; c++){
	    d[c] = ary[c];
	}
	System.out.println(Arrays.toString(d));
	int pivot = ary[r.nextInt(ei-si) + si];
	System.out.println(pivot);
	
	for (int x = si; x < ei; x++){
	    if (ary[x] == pivot){
	    } else if (ary[x] < pivot){
		d[li] = ary[x];
		System.out.println("d[li] " + d[li] + " li: " + li);
		li++;
		System.out.println(Arrays.toString(d));
	    } else {
		d[ri] = ary[x];
		System.out.println("d[ri]: " + d[ri] + " ri: " + ri);
		System.out.println(Arrays.toString(d));
		ri--;
	    }
	}
	
	d[ri] = pivot;
	System.out.println(Arrays.toString(d));

	ary = d;

	if (li == n - 1){
	    return d[li];
	}
	else if (li < n - 1){
	    return partition(n, li, ei);
	}else{
	    return partition(n, si, li);
	}
    }

    public void inPlace(int si, int ei){
	int li = si;
	int ri = ei-1;
	int hold;
	int pivot = ary[r.nextInt(ei-si) + si];
	System.out.println(Arrays.toString(ary));
	System.out.println("pivot: " + pivot);
	while (li < ri){
		if (ary[li] < pivot){
		    hold = ary[li];
		    System.out.println("looking at " + ary[li]);
		    System.out.println("li hold: " + hold);
		    // ary[li] = ary[];
		    // ary[li] = hold;
		    li++;
		    System.out.println(Arrays.toString(ary));
		} else if (ary[li] > pivot){
		    hold = ary[ri];
		    System.out.println("looking at " + ary[li]);
		    System.out.println("ri hold: " + hold);
		    ary[ri] = ary[li];
		    ary[li] = hold;
		    ri--;
		    System.out.println(Arrays.toString(ary));
		
	    }
	}
    	ary[ri] = pivot;
	System.out.println(Arrays.toString(ary));
    }


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

    public int select(int n){
	n+=1;
	return partition(n, 0, ary.length - 1);
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

	QuickSelect qs = new QuickSelect(a,10);

	System.out.println(qs.toString());
	//	partition(a,0,l);
	qs.inPlace(0,l);
	//	System.out.println(qs.select(5));
	//	System.out.println(qs.toString());
	//	System.out.println(Arrays.toString(a));
    }


}
