public class Test {
    public static void main(String[] args) {
        HeapsList1 list1 = new HeapsList1();
        HeapsList2 list2 = new HeapsList2();
        HeapsArray array1 = new HeapsArray();
        ArrayHeap array2 = new ArrayHeap();

        for(int i = 0; i < 10; i++){
            list1.add(i);
            list2.add(i);
            array1.bubble(i);
            array2.add(i);
        }

        //list1.remove();
        //list2.remove();
        //list1.print();
        //list2.print();
        array1.print();
        array1.sink();
        array1.print();
        
        System.out.println();
        
        System.out.println(array2.stringify());
        array2.remove();
        System.out.println(array2.stringify());

        
    }
}
