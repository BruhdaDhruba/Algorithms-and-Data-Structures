public class Bench {
  public static void main(String[] arg) {

    int[] sizes = {200,400,800,1600,3200,6400,12800,25600};
  
    System.out.printf("# Appending an a list/array of size n, time in ns\n");
    System.out.printf("#%7s%8s%8s\n", "n", "L", "A");
    
    for ( int n : sizes) {
      System.out.printf("%8d", n);
    
      LinkedList a = LinkedList.genList(500);
	  LinkedList b = LinkedList.genList(n);

      int[] array1 = Array.generate(500);
      int[] array2 = Array.generate(n);

	    int k = 1000;
	    
	   double min1 = Double.POSITIVE_INFINITY;

	   for (int i = 0; i < k; i++) {
		  long t0 = System.nanoTime();
		  b.append(a);
		  long t1 = System.nanoTime();
		  double t = (t1 - t0);
		  if (t < min1)
		    min1 = t;
	  }

	    System.out.printf("%8.0f", (min1));

      double min2 = Double.POSITIVE_INFINITY;

	   for (int i = 0; i < k; i++) {
		  long t0 = System.nanoTime();
		  Array.append(array2, array1);
		  long t1 = System.nanoTime();
		  double t = (t1 - t0);
		  if (t < min2)
		    min2 = t;
	  }

	    System.out.printf("%8.0f\n", (min2));
  }
 }
}
