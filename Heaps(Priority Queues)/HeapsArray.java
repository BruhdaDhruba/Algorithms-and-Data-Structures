public class HeapsArray{
    private int[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public HeapsArray() {
        heap = new int[DEFAULT_CAPACITY];
        size = 0;
    }
    
    public void bubble(int item) {
        if (size == heap.length) {
            resizeArray();
        }
        
        int currentIndex = size;
        heap[currentIndex] = item;
        size++;
        
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap[currentIndex] < heap[parentIndex]) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }
    
    public int sink() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        
        sinkDown(0);
        
        return root;
    }

    private void sinkDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if (left < size && heap[left] < heap[smallest]) {
             smallest = left;
            }
        
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        
        if (smallest != index) {
            swap(index, smallest);
            sinkDown(smallest);
        }
    }
    
    private void resizeArray() {
        int newCapacity = heap.length * 2;
        int[] newHeap = new int[newCapacity];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }
    
    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
}

