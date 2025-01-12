import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueBinaryTree implements Iterable<Integer>{
    Node root;
    
    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;
    
        public Node(Integer k, Integer v){
            this.key = k;
            this.value = v;
            this.left = null;
            this.right = null;
        }

        public Integer search(Integer k){
            if(this.key == null)
              return null;
            if(this.key == k)
              return value;
            else if(this.key > k)
              if(this.left != null)
                return left.search(k);
              else 
                return null;
            else 
              if(this.right != null)
                return right.search(k);
              else 
                return null;
        }

        
    }
    
        
        public QueueBinaryTree(){
            root = null;
        }
        
        public Integer lookup(Integer k){
            if(root != null){
             root.search(k);
            }
            return null;
        }
        
    
        public void add(Integer k, Integer v) {
            if (root != null) {
                Node cur = root;
        
                // Traverse the tree to find the correct position for the new node
                while (cur != null) {
                    if (cur.key == k) {
                        // If the key already exists, update the value
                        cur.value = v;
                        break;
                    } else if (cur.key > k) {
                        // If the key is smaller, move to the left subtree
                        if (cur.left != null) {
                            cur = cur.left;
                        } else {
                            // If the left node is null, insert a new node
                            cur.left = new Node(k, v);
                            break;  // Break out of the loop after insertion
                        }
                    } else {
                        // If the key is larger, move to the right subtree
                        if (cur.right != null) {
                            cur = cur.right;
                        } else {
                            // If the right node is null, insert a new node
                            cur.right = new Node(k, v);
                            break;  // Break out of the loop after insertion
                        }
                    }
                }
            } else {
                // If the tree is empty, create a new root node
                root = new Node(k, v);
            }
        }

        public Iterator<Integer> iterator() {
            return new TreeIterator();
        }
        
          

        private class TreeIterator implements Iterator<Integer> {
            private Node next;
            private QueueLLGeneric <Node> q;
            
            public TreeIterator() {
                q = new QueueLLGeneric<Node>(); //initializes a new queue
                next = root; //start at root
                q.enqueue(root);
            }
            
            @Override
            public boolean hasNext() {
                return next != null; // returns true if next isn't null; returns false if next is null;
            }
            
            
            @Override
            public Integer next() { // returns value of next node
                if (!hasNext()){
                    throw new NoSuchElementException();//Checks if there is next node; if not, throws exception
                }
                Integer val = next.value;
                
                q.enqueue(next.left);//Add left branch to queue
                q.enqueue(next.right);//Add right branch to queue
                
                q.dequeue();
                next = q.firstItem();
            
                return val;
            }
            
            
            
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    }

