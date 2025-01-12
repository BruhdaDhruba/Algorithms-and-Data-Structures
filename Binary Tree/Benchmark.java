import java.util.Random;
    public class Benchmark {
        public static void main(String[] args) {
            Random rand = new Random();
            int k = 1000;
            int tries = 1000;
            int bound = 100000;
            int[] sizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
            
            System.out.printf("# Lookup search for a growing tree\n");
            System.out.printf("#%7s%8s\n", "n", "L");
            
            for (int size : sizes) {
                System.out.printf("%8d", size);
                
                double min = Double.POSITIVE_INFINITY;
                for (int t = 0; t < tries; t++) {
                    int[] randomKeys = new int[k];
                    BinaryTree tree = new BinaryTree();
    
                    for (int i = 0; i < k; i++) {
                        randomKeys[i] = rand.nextInt(bound);
                    }
    
                    for (int j = 0; j < size; j++) {
                        tree.add(rand.nextInt(bound), rand.nextInt(bound));
                    }
    
                    double start = System.nanoTime();
                    for (int randomKey : randomKeys) {
                        tree.lookup(randomKey);
                    }
                    double executionTime = System.nanoTime() - start;
    
                    if (executionTime < min) {
                        min = executionTime;
                    }
                }
                System.out.printf("%8.0f\n", (min/1000));
            }
        }
}

