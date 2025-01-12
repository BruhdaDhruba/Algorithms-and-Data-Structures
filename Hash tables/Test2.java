public class Test2 {
 
    public static void main(String[] arg) {
    
    int tries = 1000;
    Zap zap1 = new Zap("/Users/dhrubadas/Desktop/ID1021/Hash tables/postnummer.csv");
    
    
    
    System.out.printf("#%7s%8s%8s\n",  "Zipcode", "Linear", "Binary");
    
    System.out.printf("%8s", "111 15");
    
      double minA = Double.POSITIVE_INFINITY;
        for(int i = 0; i < tries; i++){
            double start = System.nanoTime();
            zap1.linear(11115);
            double t = System.nanoTime() - start;
            if(t < minA)
              minA = t;
      }
      System.out.printf("%8.0f", minA);
    
      
      double minB = Double.POSITIVE_INFINITY;
        for(int i = 0; i < tries; i++){
            double start = System.nanoTime();
            zap1.binary(11115);
            double t = System.nanoTime() - start;
            if(t < minB)
              minB = t;
      }
      System.out.printf("%8.0f\n", minB);
    
      System.out.printf("%8s", "984 99");
    
      double minC = Double.POSITIVE_INFINITY;
        for(int i = 0; i < tries; i++){
            double start = System.nanoTime();
            zap1.linear(98499);
            double t = System.nanoTime() - start;
            if(t < minC)
              minC = t;
      }
      System.out.printf("%8.0f", minC);
    
      
      double minD = Double.POSITIVE_INFINITY;
        for(int i = 0; i < tries; i++){
            double start = System.nanoTime();
            zap1.binary(98499);
            double t = System.nanoTime() - start;
            if(t < minD)
              minD = t;
      }
      System.out.printf("%8.0f\n", minD);
    
      }
    }
