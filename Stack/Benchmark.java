public class Benchmark {
    public static void main(String[] args) {
        // 10 + 2 * 5
        // 10 2 5 * + in reversed Polish notation
        Item[] expr = {
        Item.Value(10),
        Item.Value(2),
        Item.Value(5),
        Item.Mul(),
        Item.Add()
        };
        
        long [] time = new long[1000];
        int res = 0;
        long startTime = System.currentTimeMillis();
        

        for(int i = 0; i < time.length; i++){
        Calculator calc = new Calculator(expr);
        res = calc.run();
        long endTime = System.currentTimeMillis();
        time[i] = endTime - startTime;
        }

        long minTime = 0;

        for(int i = 0; i < time.length - 1; i++){
            minTime = time[i];
            if(minTime > time[i + 1])
             minTime = time[i + 1];
        }
         

        System.out.println(" Calculator: res = " + res);
        System.out.println(" Minimum time taken (ms): " + minTime);
  }
  
}