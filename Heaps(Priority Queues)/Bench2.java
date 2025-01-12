import java.util.Random;

public class Bench2 {
    public static void main(String[] args) {
        int size = 1023;
        int bound = 100000;
        int accuracy = 10000;
        int[] increments = {10, 20, 40, 80, 100};
        System.out.println("Increment by:\t\tDepth:");
        for (int increment : increments) {
            int maxDepth = 0;
            Random random = new Random();
            HeapsTree listHeap = new HeapsTree();
            for (int t = 0; t < size; t++) {
                int item = random.nextInt(bound);
                listHeap.enqueue(item);
            }
            for (int j = 0; j < accuracy; j++) {
                    int depth = listHeap.push(increment);
                    if (depth > maxDepth) {
                        maxDepth = depth;
                    }
            }
            System.out.printf("%d \t\t\t %d\n", increment, maxDepth);
        }
    }
}
