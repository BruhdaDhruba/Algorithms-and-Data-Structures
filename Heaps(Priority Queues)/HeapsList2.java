public class HeapsList2 {
    Node head;

    private class Node{
        int prio;
        Node next;

        private Node(int p){
            this.prio = p;
            this.next = null;
        }
    }

    public HeapsList2(){
        head = null;
    }
    
    public void add(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public int remove() {
        if (head == null) {
            System.out.println("Heap is empty");
            return -1; 
        } else {
            Node highestPriorityNode = findHighestPriority();
            removeNode(highestPriorityNode); // O(n) time complexity
            return highestPriorityNode.prio;
        }
    }

    public Node findHighestPriority() {
        Node highestPriorityNode = head;
        Node current = head;

        while (current != null) {
            if (current.prio < highestPriorityNode.prio) {
                highestPriorityNode = current;
            }
            current = current.next;
        }

        return highestPriorityNode;
    }

    public void removeNode(Node nodeToRemove) {
        if (nodeToRemove == head) {
            head = head.next;
        } else {
            Node current = head;
            while (current.next != nodeToRemove) {
                current = current.next;
            }
            current.next = nodeToRemove.next;
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
