public class HeapsList1 {
    Node head;

    private class Node{
        int prio;
        Node next;

        private Node(int p){
            this.prio = p;
            this.next = null;
        }
    }

    public HeapsList1(){
        head = null;
    }
    
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null || value < head.prio) {
            newNode.next = head;
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null && cur.next.prio < value) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    public int remove() {
        if (head == null) {
            System.out.println("Heap is empty");
            return -1;
        } else {
            int removedValue = head.prio;
            head = head.next;
            return removedValue;
        }
    }

    public void print() {
        Node cur = head;
        while(cur != null){
            System.out.print(cur.prio + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
