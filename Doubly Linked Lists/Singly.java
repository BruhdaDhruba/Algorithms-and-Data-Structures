public class Singly {
    Node first;
    static Node [] nodeArray;
    
    public class Node {
        public int head;
        Node tail;
    
        public Node(int val, Node tl) {
            head = val;
            tail = tl;
        }
    }   
        public Singly(int n){
            nodeArray = new Node[n];
            for(int i = 0; i < n; i++){
                add(i);
                nodeArray[i] = first;
            }
        }

        public void printArray(){
            for(int i = 0; i < nodeArray.length - 1; i++){
                System.out.print(nodeArray[i].head + ",");
            }
            System.out.print(nodeArray[nodeArray.length - 1].head + "\n");
        }

        public static Node[] returnArray(){
            return nodeArray;
        }
        
        public void add(int item){
            Node newC = new Node(item, first); 
            first = newC;
        }
        
        public int length(){
            Node current = first;
            int counter = 0;
            while(current != null){
                counter++;
                current = current.tail;
            }
            return counter;
        }

        public boolean find(int item){
            Node current = first;
            while(current != null){
                if(current.head == item)
                 return true;
                current = current.tail;
            }
            return false;
        }

        public void printList(){
            Node current = first;
            while(current != null){
                System.out.print(current.head + ",");
                current = current.tail;
            }
            System.out.print("\n");
        }

        public void remove(int item){
            Node current = first;
            Node prev = null;
            while(current != null){
                if(first.head == item){
                    first = first.tail;
                    return;
                }
                if(current.head == item){
                     prev.tail = current.tail;
                     return;
                }
                prev = current;
                current = current.tail;
            }
            return;
        }

        public void append(Singly b) {
            Node current = first;
            while (current.tail != null) {
                current = current.tail;
            }
            current.tail = b.first;
            b.first = null;
        }

        public void unlink(Node gone){
            if(first == gone){
                first = first.tail;
            }

            Node current = first;
            while(current.tail != null && current.tail != gone){
                current = current.tail;
            } 
            if(current.tail == gone){
                current.tail = gone.tail;
            }
        }
    

        public void insert(Node newC){
            newC.tail = first;
            first = newC;
        }
}
