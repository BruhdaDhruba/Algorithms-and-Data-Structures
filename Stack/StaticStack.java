abstract class Stack {
    public abstract void push(int x);
    public abstract int pop();
}

public class StaticStack extends Stack{
    int sp = -1;
    int [] array = new int[8];
    public void push(int x){
        if(sp == array.length - 1){
          System.out.println("Stack is full");
         } 
         sp++;
         array[sp] = x; 
    }
    
    public int pop(){
        if(sp == -1){
        System.out.println("Stack is empty");
        }
        int y = array[sp];
        array[sp] = 0;
        sp--;
        return y;
    }
}

