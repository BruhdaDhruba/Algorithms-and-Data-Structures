import java.util.Random;



public class Test {

    
    public static void main(String[] arg) {
        Random rnd = new Random();
        int n = 10;
        Integer [] array = new Integer[n];

        for(int i = 0; i < array.length; i++){
            array[i] = rnd.nextInt(n);
        }

        QuickList<Integer> a = new QuickList<Integer>(array);
        a.print();
        a.sort();
        a.print();
        System.out.println();

        QuickArray.printArray(array);
        QuickArray.sort(array, 0, array.length - 1);
        QuickArray.printArray(array);
        
        
    }
}
