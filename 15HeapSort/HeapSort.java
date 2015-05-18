import java.util.*;

public class HeapSort {

    private static int x;

    public HeapSort(){}

    private static void swap(int[] arr, int a, int b){
        int hold = arr[a];
        arr[a] = arr[b];
        arr[b] = hold;
    }

    public static void heapSort(int[] arr){
	x = arr.length-1;
	
	for (int i = x/2; i >= 0; i--){
	    heapify(arr,i);
	}
	for (int i = x; i > 0; i--){
	    swap(arr,0,i);
	    x--;
	    heapify(arr,0);
	}
    }

    public static void heapify(int[] arr, int i){
	int l = i*2;
	int r = l+1;
	int greater = i;

	if (l <= x && arr[l] > arr[greater]){
	    greater = l;
	}
	if (r <= x && arr[r] > arr[greater]){
	    greater = r;
	}
	if (greater != i){
	    swap(arr,i,greater);
	    heapify(arr,greater);
	}
    }

    public static void main(String[]args){
	int[] ex = new int[10];
	ex[0] = 5;
	ex[1] = 9;
	ex[2] = 1;
	ex[3] = 2;
	ex[4] = 7;
	ex[5] = 0;
	ex[6] = 6;
	ex[7] = 3;
	ex[8] = 8;
	ex[9] = 4;

	System.out.println(Arrays.toString(ex));
	heapSort(ex);
	System.out.println(Arrays.toString(ex));
    }

}
