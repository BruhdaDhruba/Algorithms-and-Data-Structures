public class QueueLinkedList {
    Node first;
    Node ultimo;

    private class Node{
        Integer item;
        Node next;

        private Node(Integer itm, Node nxt){
            this.item = itm;
            this.next = nxt;
        }
    }

    public QueueLinkedList(){
        first = null;
        ultimo = null;
    }

    public void enqueue(Integer itm){
        Node last = new Node(itm, null);
        if(ultimo != null){
            ultimo.next = last;
        }
        ultimo = last;
        if(first == null){
            first = last;
        } 
    }

    public Integer dequeue(){
        if(first == null)
          return null;
        
        Integer ret = first.item;
        first = first.next;
        
        if(first == ultimo)
          first = ultimo = null;
          
        return ret;
    }


    public void printQueue(){
        Node cur = first;
        while(cur != null){
          System.out.println(cur.item);
          cur = cur.next;
        }
    }
}
