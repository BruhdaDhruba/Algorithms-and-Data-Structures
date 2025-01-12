public class LinkedList {
    Cell first = null;

    
    public class Cell {
        int head;
        Cell tail;
    
        public Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }   
        public LinkedList() {
            first = null;
        }
        
        public static LinkedList genList(int n){
            LinkedList newList = new LinkedList();
            for(int i = 0; i < n; i++){
                newList.add(i);
            }
            return newList;
        }
        
        public void add(int item){
            Cell newC = new Cell(item, first); 
            first = newC;
        }
        
        public int length(){
            Cell current = first;
            int counter = 0;
            while(current != null){
                counter++;
                current = current.tail;
            }
            return counter;
        }

        public boolean find(int item){
            Cell current = first;
            while(current != null){
                if(current.head == item)
                 return true;
                current = current.tail;
            }
            return false;
        }

        public void printList(){
            Cell current = first;
            while(current != null){
                System.out.print(current.head + ",");
                current = current.tail;
            }
            System.out.print("\n");
        }

        public void remove(int item){
            Cell current = first;
            Cell prev = null;
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

        public void append(LinkedList b) {
            Cell current = first;
            while (current.tail != null) {
                current = current.tail;
            }
            current.tail = b.first;
            b.first = null;
        }
}



 