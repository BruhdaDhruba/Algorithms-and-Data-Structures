public class QueueLLGeneric <T> {
        Node<T> first;
        Node<T> ultimo;
    
        private class Node<TT>{
            TT item;
            Node<TT> next;
    
            private Node(TT itm, Node<TT> nxt){
                this.item = itm;
                this.next = nxt;
            }
        }
    
        public QueueLLGeneric(){
            first = null;
            ultimo = null;
        }
    
        public void enqueue(T itm){
            Node<T> last = new Node<T>(itm, null);
            if(ultimo != null){
                ultimo.next = last;
            }
            ultimo = last;
            if(first == null){
                first = last;
            } 
        }
    
        public T dequeue(){
            if(first == null)
              return null;
            
            T ret = first.item;
            first = first.next;
            
            if(first == ultimo)
              first = ultimo = null;
              
            return ret;
        }

        public T firstItem() {
            return first.item;
        }
    
        public void printQueue(){
            Node<T> cur = first;
            while(cur != null){
              System.out.println(cur.item);
              cur = cur.next;
            }
        }
    }

