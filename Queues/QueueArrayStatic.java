public class QueueArrayStatic {
    Integer[] queue;
    int first, last;
    int size;
    
    public QueueArrayStatic(){
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
          System.out.println("Array full");
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
}
