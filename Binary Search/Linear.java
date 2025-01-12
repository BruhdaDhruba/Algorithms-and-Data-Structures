public class Linear{

public static Boolean search(int[] array, int key)
{
    for (int i = 0; i < array.length ; i++)
    {
        if (array[i] == key)
            return true;
    }
    return false;
}
}