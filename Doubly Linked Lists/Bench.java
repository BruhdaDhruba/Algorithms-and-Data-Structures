import java.util.Random;

public class Bench {
        public static void main(String[] arg) {
      
          int[] sizes = {1600,3200,6400,12800,25600,51200,102400};
          
        
          System.out.printf("# Unlinking and Inserting: Singly vs Doubly\n");
          System.out.printf("#%7s%8s%8s\n", "n", "S", "D");
          
          for ( int n : sizes) {
            System.out.printf("%8d", n);
          
            Singly a = new Singly(n);
            DList b = new DList(n);

            Singly.Node[] singlyArray = Singly.returnArray();
            DList.Cell[] doublyArray = DList.returnArray();
            


            Random rand = new Random();
            int k = 1000;
            int [] ref = new int[k];
            for(int i = 0; i < k; i++){
                ref[i] = rand.nextInt(n);
            }
      
            //int runs = 1;
            
              
             double min1 = Double.POSITIVE_INFINITY;
      
             //for (int i = 0; i < runs; i++) {
                long s0 = System.nanoTime();
                for(int j = 0; j < k; j++){
                  a.unlink(singlyArray[j]);
                  a.insert(singlyArray[j]);
                }
                long s1 = System.nanoTime();
                double s = (s1 - s0);
                if (s < min1)
                  min1 = s;
            //}
      
              System.out.printf("%8.0f", (min1/1000));
      
            double min2 = Double.POSITIVE_INFINITY;
      
             //for (int i = 0; i < runs; i++) {
                long t0 = System.nanoTime();
                for(int j = 0; j < k; j++){
                  b.unlink(doublyArray[j]);
                  b.insert(doublyArray[j]);
                }
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min2)
                  min2 = t;
            //}
      
              System.out.printf("%8.0f\n", (min2/1000));
        }
       }
}

