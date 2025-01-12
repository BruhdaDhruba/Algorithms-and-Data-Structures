public class Binary {
    public static Boolean search(int[] array, int key)
    {
        int first = 0;
        int last = array.length-1;
        while (true)
        {
            int index = (last+first)/2;

            if (key == array[index])
                return true;
            if (key > array[index])
                first = index+1;
            else if (key < array[index])
                last = index-1;
            if (first > last)
                return false;
        }
	
    }
}