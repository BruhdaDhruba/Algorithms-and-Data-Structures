abstract class Stack {
    public abstract void push(int x);
    public abstract int pop();
}



public class DynamicStack {
    int sp = -1;
    int [] array = new int[8];
    public void push(int x){
        if(sp == array.length - 1){
          int [] newArray = new int[array.length * 2];
          for(int i = 0; i < newArray.length; i++){
            newArray[i] = array[i];
          }
          array = newArray;
         } 
         sp++;
         array[sp] = x; 
    }
    
    public int pop(){
        int counter = 0;
        if(sp + 1 < array.length/2)
          counter--;
        else
          counter = 10;
        
        if(counter == 0){
         int [] newArray = new int [array.length/2];
         for(int i = 0; i < newArray.length; i++){
           newArray[i] = array[i];
        }
        array = newArray;
    }
        if(sp == -1){
        System.out.println("Stack is empty");
        }
        int y = array[sp];
        array[sp] = 0;
        sp--;
        return y;
    }
}
