public class SelectionSort {
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static void sort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int cand = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){
                 cand = j;
                }
            }
            swap(array, i, cand);
        }
    }
}
