import java.util.Random;

public class Bench1 {
    public static void main(String[] arg) {
     
      System.out.printf("#%6s%10s%10s\n",  "n", "Heap1", "Heap2");

      int tries = 10;
      Random rand = new Random();
      for(Integer n = 1000; n <= 10000; n += 1000){

        int [] array = new int[n];
        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(n);
        }
         
         HeapsList1 list1 = new HeapsList1();
         HeapsList2 list2 = new HeapsList2();
        
     
        System.out.printf("%8d", n);
     
        double minA = Double.POSITIVE_INFINITY;
            for(int i = 0; i < tries; i++){
            double start1 = System.nanoTime(); 
            for(int j = 0; j < array.length; j++){
                list1.add(array[j]);
            }
            for(int j = 0; j < array.length; j++){
                list1.remove();
            }              
            double t1 = System.nanoTime() - start1;
            if(t1 < minA)
               minA = t1;
            }
        System.out.printf("%8.0f", minA/(1000000));
     
       
        double minB = Double.POSITIVE_INFINITY;
            for(int i = 0; i < tries; i++){
            double start2 = System.nanoTime();
            for(int j = 0; j < array.length; j++){
                list2.add(array[i]);
            }
            for(int j = 0; j < array.length; j++){
                list2.remove();
            } 
            double t2 = System.nanoTime() - start2;
            if(t2 < minB)
               minB = t2;
            }
        System.out.printf("%10.0f\n", minB/(1000000));
     
      }
    }
}
