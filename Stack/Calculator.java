import java.util.*;

public class Calculator {
    Item[] expr;
    int ip;
    StaticStack stack;
    
    public Calculator(Item[] expr) {
    this.expr = expr;
    this.ip = 0;
    this.stack = new StaticStack();
    }

    public int run() {
        while ( ip < expr.length ) {
        System.out.println(Arrays.toString(stack.array));
        step();
        }
        return stack.pop();
    }

        public void step() {
            Item nxt = expr[ip++];
            switch(nxt.getType()) {
            
                case ADD : {
                    int y = stack.pop();
                    int x = stack.pop();
                    stack.push(x + y);
                    break;
                }

                case SUB : {
                    int y = stack.pop();
                    int x = stack.pop();
                    stack.push(x - y);
                    break;
                }

                case DIV : {
                    int y = stack.pop();
                    int x = stack.pop();
                    stack.push(x / y);
                    break;
                }

                case MUL : {
                    int y = stack.pop();
                    int x = stack.pop();
                    stack.push(x * y);
                    break;
                }
                
                 case VALUE : {
                    stack.push(nxt.getValue());
                }
   
        }
    }
}