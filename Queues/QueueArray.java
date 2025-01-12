public class QueueArray {

    Integer[] queue;
    int first, last;
    int size;
    
    public QueueArray(){
        size = 4;

        queue = new Integer[size];

        first = 0;
        last = 0;
    }
    
    public boolean isEmpty(){
        return first == last;
    }

    public void enqueue(Integer itm){
        queue[last] = itm;
        last = (last + 1) % size;
        if(last == first){
            Integer[] copy = new Integer[size*2];
            int c = 0;
            for(int i = first; i < size; i++){
                copy[c++] = queue[i];
            }

            queue = copy;
            first = 0;
            last = c;
            size = size*2;
        }
    } 

    public Integer dequeue(){
        if(isEmpty())
          return null;
        Integer ret = queue[first];
        queue[first] = null;

        if(first == last){
            first = 0;
        }
        else{
            first++;
        }
        return ret;
    }

    public void printQueue(){
        for(int i = 0; i < queue.length; i++){
            System.out.println(queue[i]);
        }
    }
}
