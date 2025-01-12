public class QuickArray {

    public static void swap(Integer[]array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int partition(Integer[] array, int start, int end){
        int pivot = array[end];
        int i = start - 1;

        for(int j = start; j <= end - 1; j++){
            if(array[j] < pivot){
                i++;
                swap(array, i, j);
            }
        }
        i++;
        swap(array, i, end);
        return i;
    }

    public static void sort(Integer[] array, int start, int end){
        if(end <= start)
          return;
        
        int pivot = partition(array, start, end);
        sort(array, start, pivot - 1);
        sort(array, pivot + 1, end);
        
    }

    public static void printArray(Integer[] array){
        System.out.print("[ " + array[0] );
        for(int i = 1; i < array.length; i++){
            System.out.print(", " + array[i]);
        }
        System.out.println(" ]");
    }
}