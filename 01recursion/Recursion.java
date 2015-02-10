public class Recursion { // implements hw1 {

    public String name(){
	return "Redler,Emily";
    }	

    public int fact(int n){
	return factHelp(n, 1);
    }

    private int factHelp(int n, int total){
	if (n < 2){
	    return total;
	}	
	total *= n;
	n -= 1;
	return factHelp(n, total);
    }

    public int fib(int n){
	return fibHelp(n, 0, 1);
    }

    private int fibHelp(int n, int prev, int current){
	if (n < 2){
	    return current;
	}
	int temp = current;
	current += prev;
	return fibHelp(n-1, temp, current);
    } 

    //guess = (n/guess+guess)/2
	
    public double sqrt(double n){
	
	return sqrtHelp(n, n);
	
    }
	
    private double sqrtHelp(double n, double guess){
	
	if (n == 0){
	    return 0;
	}

	if (n < 0){
	    System.out.println("number not within range (below)");
	    return n;
	}

	if (n / (guess*guess) < 1.01 && n / (guess*guess) > .99){
	    return guess;
	}
	guess = (n/guess+guess)/2;
	return sqrtHelp(n,guess);
		
    }

    /*
      public static void main (String[]args){
	  Recursion r = new Recursion();	  

	  System.out.println(r.name()); //should be Redler,Emily
	  System.out.println(r.fact(4)); //should be 24
	  System.out.println(r.fib(4)); //should be 3 (starts counting from 0, so 0 is oth, 1 is 1st, etc.);
	  System.out.println(r.sqrt(100)); //should be ~10
      }
    */
}
