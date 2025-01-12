public class Test {
    public static void main(String[] args) {
        QueueArray q = new QueueArray();

        for(int i = 0; i < 10; i++){
            q.enqueue(i);
        }

        q.dequeue();
        q.printQueue();
    }
}
