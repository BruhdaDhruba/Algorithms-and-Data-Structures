import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree implements Iterable<Integer>{
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
    
        
        public BinaryTree(){
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
                            // If the left child is null, insert a new node
                            cur.left = new Node(k, v);
                            break;  // Break out of the loop after insertion
                        }
                    } else {
                        // If the key is larger, move to the right subtree
                        if (cur.right != null) {
                            cur = cur.right;
                        } else {
                            // If the right child is null, insert a new node
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
            private Stack<Node> stack;
            
            public TreeIterator() {
                stack = new Stack<Node>(); //initializes a new stack
                next = root; //start at root
                while(next.left != null){
                    stack.push(next); //push the nodes on the stack as we go down; done using temp. node as we don't want to change the root 
                    next = next.left; // go down to leftmost leaf
                }
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
        
                Node current = stack.peek(); //current node is set to parent node
                Node nxtVal = stack.pop(); // node that we want the value of 
                
                if(current.right != null){ //checks, after popping, if next node has a right branch 
                    current = current.right; // if yes, we move to that branch
                    while (current != null){ //move to leftmost node of the right branch
                        stack.push(current);
                        current = current.left;
                    }
                }
                if(stack.isEmpty()){ //checks if stack is empty i.e if we have reached the last node
                    next = null;
                }
                else{
                    next = stack.peek(); // if not, we return to the parent node and keep traversing in ascending order
                }
                return nxtVal.value;
            }
            
            
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    }


    

