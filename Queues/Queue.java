public class Queue{
    Node head;
    
    public class Node {
    Integer item;
    Node next;
    private Node(Integer item, Node next) {
        this.item = item;
        this.next = next;
      }
    }
    
    public Queue(){
        head = null;
    }

    public void add(Integer item){
        Node newC = new Node(item, head);
        head = newC;
    }

    public Integer remove(){
        if(head == null){
            System.out.println("Empty queue");
        }
        Node cur = head;
        Node prev = null;
        while(cur.next != null){
            prev = cur;
            cur = cur.next;
        }
        Integer val = cur.item;
        cur = prev;
        cur.next = null;
        return val;
    }

    public void printQueue(){
        Node cur = head;
        while(cur != null){
          System.out.println(cur.item);
          cur = cur.next;
        }
    }

}

