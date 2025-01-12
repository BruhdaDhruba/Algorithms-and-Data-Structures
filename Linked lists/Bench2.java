public class Bench2 {
    public static void main(String[] arg) {

        int[] sizes = {200,400,800,1600,3200,6400,12800,25600};
      
        System.out.printf("# Time to create list/array of size n, time in ns\n");
        System.out.printf("#%7s%8s%8s\n", "n", "L", "A");
        
        for ( int n : sizes) {
          System.out.printf("%8d", n);
        
          //LinkedList b = new LinkedList(500);
    
          //int[] array1 = new int[n];
          //int[] array2 = new int[500];
    
          //for(int i = 0; i < n; i++)
           //array1[i] = i;
    
          //for(int i = 0; i < array2.length; i++)
           //array2[i] = i;
    
            int k = 1000;
            
           double min1 = Double.POSITIVE_INFINITY;
    
           for (int i = 0; i < k; i++) {
              long t0 = System.nanoTime();
              LinkedList a = LinkedList.genList(n);
              long t1 = System.nanoTime();
              double t = (t1 - t0);
              if (t < min1)
                min1 = t;
          }
    
            System.out.printf("%8.0f", (min1));
    
          double min2 = Double.POSITIVE_INFINITY;
    
           for (int i = 0; i < k; i++) {
              long t0 = System.nanoTime();
              int[] array1 = new int[n];
              long t1 = System.nanoTime();
              double t = (t1 - t0);
              if (t < min2)
                min2 = t;
          }
    
            System.out.printf("%8.0f\n", (min2));
      }
     }
}
