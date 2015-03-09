import java.util.*;

public class Sorts {
    public static int[] ary;
    public int len;

    public static Random r = new Random();

    public Sorts(int[] a, int l){
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
	//	System.out.println(Arrays.toString(d));
	int pivot = ary[r.nextInt(ei-si) + si];
	//	System.out.println(pivot);
	
	for (int x = si; x < ei; x++){
	    if (ary[x] == pivot){
	    } else if (ary[x] < pivot){
		d[li] = ary[x];
		//		System.out.println("d[li] " + d[li] + " li: " + li);
		li++;
		//		System.out.println(Arrays.toString(d));
	    } else {
		d[ri] = ary[x];
		//	System.out.println("d[ri]: " + d[ri] + " ri: " + ri);
		//	System.out.println(Arrays.toString(d));
		ri--;
	    }
	}
	
	d[ri] = pivot;
	System.out.println(Arrays.toString(d));

	ary = d;

	if (li == n-1){
	    return d[li];
	}
	else if (li < n-1){
	    return partition(n, li, ei);
	}else{
	    return partition(n, si, li);
	}
    }

    //
    //
    //works with all cases except n = a.length-1
    public static int inPlace(int n, int si, int ei){
	int li = si;
	int ri = ei-1;
	int hold;
	int pivot = ary[r.nextInt(ei-si) + si];
	System.out.println(Arrays.toString(ary));
	System.out.println("pivot: " + pivot);
	while (li < ri){
	    //	    System.out.println("li: " + li + "  ri: " + ri);
	    if (ary[li] < pivot){
		//	System.out.println("looking at " + ary[li]);
		//	System.out.println("li hold: " + hold);
		// ary[li] = ary[];
		// ary[li] = hold;
		li++;
		//		System.out.println(Arrays.toString(ary));
	    } else if (ary[li] > pivot){
		hold = ary[ri];
		//	System.out.println("looking at " + ary[li]);
		//	System.out.println("ri hold: " + hold);
		ary[ri] = ary[li];
		ary[li] = hold;
		ri--;
		//		System.out.println(Arrays.toString(ary));		
	    } else {
		hold = ary[ri];
		ary[ri] = ary[li];
		ary[li] = hold;
		//	ri--;
		
	    }
	}

	if (li == n){
	    return ary[li];
	}
	else if (li < n){
	    return inPlace(n, li, ei);
	}else{
	    return inPlace(n, si, li);
	}
	//	ary[ri] = pivot;
	//System.out.println(Arrays.toString(ary));
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

    //
    //weird with some cases (eg len of list -1)
    //
    //select using partition
    //
    public int selectP(int n){
	return partition(n, 0, ary.length - 1);
    }

    //also weird with some cases
    //
    //select using inPlace
    //
    public static int selectIP(int n){
	return inPlace(n, 0, ary.length - 1);
    }

    /*
    // doesn't compile
    //
    // should only have 1 argument: int[]    
    public static void quickSort(int[] a, int li, int ei){
	int where = a.length/2;
	int x = a[where];
	if (a.length/2 >= 1){	
	    // (ei-li)/2
	    //           |
	    //           |  selectIP() returns an int, argument supposed to be int[]
	    //           V
	    quickSort(selectIP(l.length/2), li, where);
	    quickSort(selectIP(l.length/2), where, ei);
	} else {
	    //   return a;
	}
	}*/

    public static void main(String[]args){
	int l = 11;
	int[] a = new int[l];

	for (int i = 0; i < l; i++){
	    int n = r.nextInt(100)+1;
	    if (!in(a,n)){
		a[i] = n;
	    } else {
		i--;
	    }
	}

	Sorts qs = new Sorts(a,l);

	System.out.println(qs.toString());
	//	partition(a,0,l);
	//	System.out.println(quickSort(a));
	//System.out.println(qs.selectP(5));
	//	System.out.println(qs.selectIP(5));
	//	System.out.println(qs.selectIP(10));
	//	System.out.println(qs.select(6));
	//	System.out.println(qs.toString());
	//	System.out.println(Arrays.toString(a));
    }


}
