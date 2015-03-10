import java.util.*;

public class Sorts {

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

    public static int[] copyHalf(int[] a, int whichHalf){
	int[] ans = new int[a.length/2];
	int size = ans.length;
	if (whichHalf == 1){
	    for (int i = 0; i < size; i++){
		ans[i] = a[i];
	    }
	} else {
	    ans = new int[a.length-size];
	    for (int i = size; i < a.length; i++){
		ans[i-size] = a[i];
	    }
	}
	return ans;
    }

    public static int[] mergeSort(int[] x){
	if (x.length < 2){
	    return x;
	}
	return merge(mergeSort(copyHalf(x,1)),mergeSort(copyHalf(x,2)));
	
    }

    public static String toString(int[] a){
	String ans = "[ " + a[0];
	for(int i = 1; i < a.length; i++){
	    ans += ", " + a[i];
	}
	ans += " ]";
	return ans;
    }

    public static void main(String[]args){
	int n = 50000000;
	int[] a = new int[n];
	Random r = new Random();

	for (int i = 0; i < n; i++){
	    a[i] = r.nextInt(20)+1;
	}	

	try {
	    int type = Integer.parseInt(args[0]);
	    if (type == 0){
		Arrays.sort(a);
	    } else {
		mergeSort(a);
	    }
	} catch (IndexOutOfBoundsException e){
	    
	   
	}
    }

}
