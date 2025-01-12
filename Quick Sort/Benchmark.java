import java.util.Random;

public class Benchmark {
 
public static void main(String[] arg) {

   Random rnd = new Random();

   int tries = 10;

System.out.printf("#%7s%8s%8s\n",  "n", "Array", "List");

 for(Integer n = 1000; n <= 10000; n += 1000){

    Integer[] array = new Integer[n];
    for(int i = 0; i < n; i++){
     array[i] = rnd.nextInt(n);
    }

    Integer[] clone = array.clone();

    QuickList<Integer> a = new QuickList<Integer>(array);

    System.out.printf("%8d", n);

  double minA = Double.POSITIVE_INFINITY;
    for(int i = 0; i < tries; i++){
        double start = System.nanoTime();
        QuickArray.sort(clone, 0, clone.length - 1);
        double t = System.nanoTime() - start;
        if(t < minA)
          minA = t;
  }
  System.out.printf("%8.0f", minA/(1000));

  
  double minL = Double.POSITIVE_INFINITY;
    for(int i = 0; i < tries; i++){
        double start = System.nanoTime();
        a.sort();
        double t = System.nanoTime() - start;
        if(t < minL)
          minL = t;
  }
  System.out.printf("%8.0f\n", minL/(1000));

  }
 }
}




