import java.util.Random;

public class Bench2 {
    private static void linear(int[] array, int[] indx) {
        for (int i = 0; i < indx.length ; i++) {
            Linear.search(array, indx[i]);
        }
        }
        
    
        private static void binary(int[] array, int[] indx) {
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
    
        int[] sizes = {1000000};
    
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s\n", "n", "linear", "binary");
        for ( int n : sizes) {
    
            int loop = 10000;
            
            int[] array = sorted(n);
            int[] indx = keys(loop, n);
    
            System.out.printf("%8d", n);
    
            int k = 1000;
            
            double min = Double.POSITIVE_INFINITY;
    
            /*for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            linear(array, indx);
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
            }*/
    
            System.out.printf("%8.0f", (min/loop));	    
    
            min = Double.POSITIVE_INFINITY;
            
            for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            binary(array, indx);
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
            }
    
            System.out.printf("%8.0f\n" , (min/loop));	    	    
        }
        }
}
    

