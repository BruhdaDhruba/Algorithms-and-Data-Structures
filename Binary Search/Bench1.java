import java.util.Random;


public class Bench1 {

    public static void linear(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	    Linear.search(array, indx[i]);
	}
    }
    

    public static void binary(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	    Binary.search(array, indx[i]);
	}
    }

       
    private static int[] sorted(int n) {
	Random rnd = new Random();	
	int[] array = new int[n];
	int nxt = rnd.nextInt(10);

	for (int i = 0; i < n ; i++) {
	    array[i] = nxt;
	    nxt += rnd.nextInt(10) + 1 ;
	}	
	return array;
    }


    private static int[] keys(int loop, int n) {
	Random rnd = new Random();	
	int[] indx = new int[loop];
	for (int i = 0; i < loop ; i++) {
	    indx[i] = rnd.nextInt(n*5);
	}	
	return indx;
    }

    
    public static void main(String[] arg) {

	int[] sizes = {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};

	System.out.printf("# searching through an array of length n, time in ns\n");
	System.out.printf("#%7s%8s\n", "n", "binary");
	for ( int n : sizes) {

	    int loop = 10000;
	    
	    int[] array1 = sorted(n);
		int[] array2 = sorted(n);
	    int[] indx = keys(loop, n);

	    System.out.printf("%8d", n);

	    int k = 1000;
	    
	    double min = Double.POSITIVE_INFINITY;

	    /*for (int i = 0; i < k; i++) {
		long t0 = System.nanoTime();
		linear(array1, array2);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min)
		    min = t;
	    }

	    System.out.printf("%8.0f", (min/k));*/	    

	    min = Double.POSITIVE_INFINITY;
	    
	    for (int i = 0; i < k; i++) {
		long t0 = System.nanoTime();
		binary(array1, array2);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min)
		    min = t;
	    }

	    /*System.out.printf("%8.0f" , (min/k));
		
		min = Double.POSITIVE_INFINITY;
	    
	    for (int i = 0; i < k; i++) {
		long t0 = System.nanoTime();
		FinalSearch.search(array1, array2);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min)
		    min = t;
	    }*/

	    System.out.printf("%8.0f\n" , (min/k));
	}
    }
}
