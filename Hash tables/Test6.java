public class Test6 {
 
    public static void main(String[] arg) {
    
    int tries = 1000;
    Better better1 = new Better("/Users/dhrubadas/Desktop/ID1021/Hash tables/postnummer.csv",10000);
    
    
    
    System.out.printf("#%7s%8s\n",  "Zipcode","Lookup");
    
    System.out.printf("%8s", "111 15");
    
      double minA = Double.POSITIVE_INFINITY;
        for(int i = 0; i < tries; i++){
            double start = System.nanoTime();
            better1.lookup(11115);
            double t = System.nanoTime() - start;
            if(t < minA)
              minA = t;
      }
      System.out.printf("%8.0f\n", minA);
    
    
    System.out.printf("%8s", "984 99");
    
      double minC = Double.POSITIVE_INFINITY;
        for(int i = 0; i < tries; i++){
            double start = System.nanoTime();
            better1.lookup(98499);
            double t = System.nanoTime() - start;
            if(t < minC)
              minC = t;
      }
      System.out.printf("%8.0f\n", minC);

    }
}
