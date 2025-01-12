public class InsertionSort {
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static void sort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i; j > 0 && (array[j] < array[j - 1]); j--)
             swap(array, j, j-1);
        }
    }
}
