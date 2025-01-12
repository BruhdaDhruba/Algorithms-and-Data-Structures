import java.util.Random;

public class Benchmark {
 
public static void main(String[] arg) {

   Random rnd = new Random();

   int loop = 10;
   int tries = 10;

System.out.printf("#%7s%8s%8s%8s%8s\n",  "n", "select", "insert", "merge", "UMerge");

 for(int n = 1000; n <= 16000; n += 1000){

    int[] array = new int[n];
    for(int i = 0; i < n; i++){
     array[i] = rnd.nextInt(n*10);
    }

    System.out.printf("%8d", n);

    double minS = Double.POSITIVE_INFINITY;
    for(int i = 0; i < tries; i++){
      double start = System.nanoTime();
      for(int j = 0; j < loop; j++){
        int [] clone = array.clone();
        SelectionSort.sort(clone);
    }
    double t = System.nanoTime() - start;
    if(t < minS)
     minS = t;
  }
  System.out.printf("%8.0f", minS/(loop*1000));

  double minl = Double.POSITIVE_INFINITY;
    for(int i = 0; i < tries; i++){
      double start = System.nanoTime();
      for(int j = 0; j < loop; j++){
        int [] clone = array.clone();
        InsertionSort.sort(clone);
    }
    double t = System.nanoTime() - start;
    if(t < minl)
     minl = t;
  }
  System.out.printf("%8.0f", minl/(loop*1000));

  double minM = Double.POSITIVE_INFINITY;
    for(int i = 0; i < tries; i++){
      double start = System.nanoTime();
      for(int j = 0; j < loop; j++){
        int [] clone = array.clone();
        MergeSort.sort(clone);
    }
    double t = System.nanoTime() - start;
    if(t < minM)
     minM = t;
  }
  System.out.printf("%8.0f", minM/(loop*1000));

  double minU = Double.POSITIVE_INFINITY;
    for(int i = 0; i < tries; i++){
      double start = System.nanoTime();
      for(int j = 0; j < loop; j++){
        int [] clone = array.clone();
        UMerge.sort(clone);
    }
    double t = System.nanoTime() - start;
    if(t < minU)
     minU = t;
  }
  System.out.printf("%8.0f\n", minU/(loop*1000));
  }
 }
}




