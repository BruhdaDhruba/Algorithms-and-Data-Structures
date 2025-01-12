public class FinalSearch {
    public static int search(int[] array1, int[] array2) 
    {
        int counter = 0;
        int i = 0;
        int j = 0;

        while (i<array1.length-1 && j<array2.length-1)
        {
            if (array1[i] > array2[j])
                j++;
            if (array1[i] < array2[j])
                i++;
            else
            {
                counter++; 
                i++; 
                j++;
            }
        }
        return counter;
    } 
}


