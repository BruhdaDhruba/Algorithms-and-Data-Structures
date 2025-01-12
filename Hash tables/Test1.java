public class Test1 {
 
public static void main(String[] arg) {

int tries = 1000;
Zoppity zip1 = new Zoppity("/Users/dhrubadas/Desktop/ID1021/Hash tables/postnummer.csv");



System.out.printf("#%7s%8s%8s\n",  "Zipcode", "Linear", "Binary");

System.out.printf("%8s", "111 15");

  double minA = Double.POSITIVE_INFINITY;
    for(int i = 0; i < tries; i++){
        double start = System.nanoTime();
        zip1.linear("111 15");
        double t = System.nanoTime() - start;
        if(t < minA)
          minA = t;
  }
  System.out.printf("%8.0f", minA);

  
  double minB = Double.POSITIVE_INFINITY;
    for(int i = 0; i < tries; i++){
        double start = System.nanoTime();
        zip1.binary("111 15");
        double t = System.nanoTime() - start;
        if(t < minB)
          minB = t;
  }
  System.out.printf("%8.0f\n", minB);

  System.out.printf("%8s", "984 99");

  double minC = Double.POSITIVE_INFINITY;
    for(int i = 0; i < tries; i++){
        double start = System.nanoTime();
        zip1.linear("984 99");
        double t = System.nanoTime() - start;
        if(t < minC)
          minC = t;
  }
  System.out.printf("%8.0f", minC);

  
  double minD = Double.POSITIVE_INFINITY;
    for(int i = 0; i < tries; i++){
        double start = System.nanoTime();
        zip1.binary("984 99");
        double t = System.nanoTime() - start;
        if(t < minD)
          minD = t;
  }
  System.out.printf("%8.0f\n", minD);

  }
}


