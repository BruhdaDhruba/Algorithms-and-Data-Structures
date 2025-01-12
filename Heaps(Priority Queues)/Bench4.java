public class Bench4 {
    
    public static void main(String[] args) throws Exception {
        HeapsTree LinkedHeap = new HeapsTree();
        HeapsArray ArrayHeap = new HeapsArray();
        int n = 100 ;
        int array[] = new int[n];

        for(int i = 0; i<n; i++){
            array[i] = (int)(Math.random() * n*n);
        }

        long n0 = System.nanoTime();
        for(int i = 0; i < n; i++){
            LinkedHeap.enqueue(array[i]);
        }
        for(int i = 0; i < n; i++){
            LinkedHeap.dequeue();
        }
        long n1 = System.nanoTime();
        System.out.println("Linked Heap: " + (n1 - n0)/1000);

        long n2 = System.nanoTime();
        for(int i = 0; i < n; i++){
            ArrayHeap.bubble(array[i]);
        }
        for(int i = 0; i < n; i++){
            ArrayHeap.sink();
        }
        long n3 = System.nanoTime();
        System.out.println("Array Heap: " + (n3 - n2)/1000);
        System.out.println();


    }
}
