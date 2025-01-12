public class HeapsTree {
    Node root;

    private class Node{
        Integer prio;
        int size;
        Node left,right;

        private Node(int p){
            this.prio = p;
            this.left = null;
            this.right = null;
        }

        private void add(int pr){
            if(pr < prio){
                Integer temp = prio;
                prio = pr;
                pr = temp;
            }
            if(right != null){
              if(left != null){
                if(left.size < right.size)
                  left.add(pr);
                else
                  right.add(pr);
              }
              else 
                left = new Node(pr);
            }
            else
              right = new Node(pr);
        }

        private Node remove(){
            if(right == null)
              return left;
            if(left == null)
              return right;
            if(left.prio < right.prio){
              prio = left.prio;
              left = left.remove();
            } else {
                prio = right.prio;
                right = right.remove();
            } 
            return this;
        }

        private int push(int incr) {
          int depth = 0; // What we want to return
          prio = prio + incr;

          if (left != null && prio > left.prio) {//Check whether we swap with the left Node
              swap(this, left);
              depth++;
              depth += left.push(0);
          } else if (right != null && prio > right.prio) { // Check whether we swap with the right Node
              swap(this, right);
              depth++;
              depth += right.push(0);
          }

          return depth;
        }

        private void swap(Node a, Node b) {
          int temp = a.prio;
          a.prio = b.prio;
          b.prio = temp;
        }

    }

    
    public HeapsTree(){
        root = null;
    }

    public void enqueue(int p){
        if(root == null)
          root = new Node(p);
        else
          root.add(p);
    }

    public int dequeue(){
        if(root == null)
          return -1;
        int p = root.prio;
        root = root.remove();
        return p;
    }

    public int push(int incr) {
      int depth = 0;
      if (root != null) {
        depth = root.push(incr);
      }
      return depth;
    }
  
}

  



    
