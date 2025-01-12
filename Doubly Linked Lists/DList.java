public class DList{
    Cell first;
    static Cell [] cellArray;

    
    public class Cell {
        int value;
        Cell prev;
        Cell next;
    
        public Cell(int val) {
            this.value = val;
        }
    }   
        public DList(int n) {
            cellArray = new Cell[n];
            for(int i = 0; i < n; i++){
                add(i);
                cellArray[i] = first;
            }
        }
        
        public void printArray(){
            for(int i = 0; i < cellArray.length - 1; i++){
                System.out.print(cellArray[i].value + ",");
            }
            System.out.print(cellArray[cellArray.length - 1].value + "\n");
        }

        public static Cell[] returnArray(){
            return cellArray;
        }


   
        public void add(int item) {  
            //Create a new Cell  
            Cell newC = new Cell(item);  
       
            //if list is empty,  newC is first
            if(first == null) {  
                first = newC;  
            }  
            else {  
                //add newC to the beginning of list. 
                first.prev = newC;
                //newNode->previous set to tail  
                newC.next = first;  
                //newNode becomes new tail  
                first = newC;  
                //tail's next point to null  
                newC.prev = null;  
            }  
        }  

        
        public int length(){
            Cell current = first;
            int counter = 0;
            while(current != null){
                counter++;
                current = current.next;
            }
            return counter;
        }

        public boolean find(int item){
            Cell current = first;
            while(current != null){
                if(current.value == item)
                 return true;
                current = current.next;
            }
            return false;
        }

        public void printList(){
            Cell current = first;
            while(current != null){
                System.out.print(current.value + ",");
                current = current.next;
            }
            System.out.print("\n");
        }

        public void remove(int item){
            if(first.value == item){
                first = first.next;
                first.prev = null;
            }
            Cell current = first;
            while(current.next != null){
                if(current.value == item){
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                    return;
                }
            current = current.next;
            }
            if(current.value == item && current.next == null){
                current = current.prev;
                current.next = null;
            }
        }

        public void append(DList b) {
            Cell current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = b.first;
            b.first = null;
        }

        public void unlink(Cell gone){
            if(first == gone){
                first = first.next;
            }
            if(gone.next != null){
                gone.next.prev = gone.prev; 
            }
            if(gone.prev != null){
                gone.prev.next = gone.next;
            }
        }

        public void insert(Cell newC){
            newC.next = first;
            newC.prev = null;
            first = newC;
        }

        
}