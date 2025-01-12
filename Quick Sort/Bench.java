import java.util.Random;

public class Bench {
        public static Integer[] createArray(int n, int bound) {
            Random rnd = new Random();
            Integer[] array = new Integer[n];
            for (int a = 0; a < array.length; a++) {
                array[a] = rnd.nextInt(bound);
            }
            return array;
        }
    
        public static void main(String[] args) {
            int[] sizes = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600};
            int bound = 1000;
            int tries = 1000;
            System.out.printf("#%7s%8s%8s\n",  "n", "Array", "List");
            for (int size : sizes) {

                System.out.printf("%8d", size);
                Integer[] array = createArray(size, bound);
                double min2 = Double.POSITIVE_INFINITY;
                double min1 = Double.POSITIVE_INFINITY;
                
                for (int t = 0; t < tries; t++) {
                    Integer[] clone = array.clone();
    
                    double arrayStart = System.nanoTime();
                    QuickArray.sort(clone, 0, clone.length - 1);
                    double arrayTime = System.nanoTime() - arrayStart;
    
                    if (arrayTime < min2) {
                        min2 = arrayTime;
                    }
                }
                System.out.printf("%8.0f", min2/(1000));

                
                for (int t = 0; t < tries; t++) {
                    QuickList<Integer> list = new QuickList<Integer>(array);
    
                    double listStart = System.nanoTime();
                    list.sort();
                    double listTime = System.nanoTime() - listStart;
    
                    if (listTime < min1) {
                        min1 = listTime;
                    }
                }
                System.out.printf("%8.0f\n", min1/(1000));
            }
        }
    }
