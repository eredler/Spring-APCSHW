public class Driver {

    public static void main(String[]args){
	Recursion recursion = new Recursion();
	double[]sqrtValues = {169.0,1.0,0.00000001,0.0,-100.0};
	int[] fibValues = {0,2,5,10,-1};
	int[] factValues = {0,1,5,-1};

	for (int i = 0; i < 5; i++){
	    System.out.println("sqrt " + i + ": " + recursion.sqrt(sqrtValues[i]));
	    System.out.println("fib " + i + ": " + recursion.fib(fibValues[i]));
	}

	for (int i = 0; i < 4; i++) {
	    System.out.println("fact " + i + ": " + recursion.fact(factValues[i])); 
	}
	
    }
}
