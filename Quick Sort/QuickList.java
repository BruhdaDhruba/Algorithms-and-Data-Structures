public class QuickList<T extends Comparable<T>> {
    Node first;
    Node last;

    public QuickList(){
        this.first = null;
        this.last = null;
    }

    //Takes array and turns it into linked list
    public QuickList(T[] arr){ 
        if(arr.length == 0){
            this.first = null;
            this.last = null;
        } 
        else{
            this.first = new Node(arr[0], null);
            Node cur = this.first;
            for(int i = 1; i < arr.length; i++){
                cur.next = new Node(arr[i], null);
                cur = cur.next;
            }
            this.last = cur;
        }
    }

    public class Node{
        T item;
        Node next;

        private Node(T itm, Node nxt){
            this.item = itm;
            this.next = nxt;
        }
    }

    //Adds item, not node, to beginning of linked list
    public void add(T itm){
        Node nd = new Node(itm, this.first);
        if(this.last == null)
          this.last = nd;
        this.first = nd;
    }
    
    public T max(){
        Node cur = this.first;
        if(cur == null){
            return null;
        }
        T mx = cur.item;
        cur = cur.next;
        while(cur != null){
            if(mx.compareTo(cur.item) < 0){
                mx = cur.item;
            }
            cur = cur.next;
        }
        return mx;
    }

    //Appends a linked list to the end of another
    public void append(QuickList<T> tail){
        if(tail != null){
            if(this.last != null)
              this.last.next = tail.first;
            else
              this.first = tail.first;
            if(tail.last != null)
              this.last = tail.last;
        }
    }

    //Appends a linked list to the front of another
    public void prepend(QuickList<T> front){
        if(front != null){
            if(front.last != null)
              front.last.next = this.first;
            if(this.last == null)
              this.last = front.last;
            if(front.first != null)
              this.first = front.first;

        }
    }

    //Adds node to beginning of linked list
    public void cons(Node nd){
        if(this.last == null) // Check if list is empty
          this.last = nd;
        nd.next = this.first; //If not, make nd the first node in list
        this.first = nd;
    }

    //Prints linked list
    public void print(){
        System.out.print("[ ");
        Node cur = this.first;
        if(cur != null){
            System.out.print(cur.item);
            cur = cur.next;
        }
        while(cur != null){
            System.out.print(", " + cur.item);
            cur = cur.next;
        }
        System.out.println(" ]");
    }

    public void sort(){
        if(this.first == null || this.first.next == null)
          return;

        QuickList<T> smaller = new QuickList<T>();
        QuickList<T> larger = new QuickList<T>();

        Node pivot = this.first;
        Node cur = pivot.next;
        pivot.next = null;

        //pivot is now the only element in the linked list
        this.last = pivot;

        T p = pivot.item;

        while(cur != null){
            Node nxt = cur.next;
            if(p.compareTo(cur.item) > 0) {
                smaller.cons(cur);
            } else {
                larger.cons(cur);
            }
            cur = nxt;
        }
        smaller.sort();
        larger.sort();
        //this holds pivot
        this.append(larger);
        this.prepend(smaller);
    }
}
