import java.util.Random;

public class Bench3 {

    static Random rand = new Random();

    public static int[] createArray(int size, int bound){
        int [] array = new int[size];
        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(bound);
        }
        return array;
    }
    
    public static void main(String[] args) {
            int size = 1023;
            int bound = 100000;
            int accuracy = 100;
            int[] operations = {100, 200, 400, 800, 1600};
            int attempt = 0;
        for (int operation : operations) {
                double min1 = Double.POSITIVE_INFINITY;
                double min2 = Double.POSITIVE_INFINITY;
                int maxDepth = 0;
                for (int j = 0; j < accuracy; j++) {
                    min1 = Double.POSITIVE_INFINITY;
                    min2 = Double.POSITIVE_INFINITY;
                    maxDepth = 0;
                    Random random = new Random();
                    int[] increments = createArray(operation, 100);
                    HeapsTree listHeap1 = new HeapsTree();
                    HeapsTree listHeap2 = new HeapsTree();
                    for (int t = 0; t < size; t++) {
                        int item = random.nextInt(bound);
                        listHeap1.enqueue(item);
                        listHeap2.enqueue(item);
                    }
                        double start1 = System.nanoTime();
                        for (int o = 0; o < operation; o++) {
                            int depth = listHeap1.push(increments[o]);
                            if (depth > maxDepth) {
                                maxDepth = depth;
                            }
                        }
                        double time1 = System.nanoTime() - start1;
                        if (time1 < min1) {
                            min1 = time1;
                        }
                        double start2 = System.nanoTime();
                        for (int o = 0; o < operation; o++) {
                            int removedItem = listHeap2.dequeue();
                            removedItem += increments[o];
                            listHeap2.enqueue(removedItem);
                        }
                        double time2 = System.nanoTime() - start2;
                        if (time2 < min2) {
                            min2 = time2;
                        }
                }
                System.out.printf("%d \t\t\t %.2f \t\t\t\t\t %.2f\t\t%d\n", operations[attempt], min1 / 1000, min2 / 100000, maxDepth);
                attempt++;
            }
        }
    }

