public class Array {

    public static int[] generate(int len) {
		int[] res = new int[len];
		for (int i = 0; i < len; i++) {
			res[i] = i;
		}
		return res;
	}

    public static int[] append(int[] a, int[] b) {
        int[] newArray = new int[a.length + b.length];
    
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i];
        }
    
        for (int i = 0; i < b.length; i++) {
            newArray[a.length + i] = b[i];
        }
    
        return newArray;
    }

    public static void printArray(int[] a){
        System.out.print("[");
        for(int i = 0; i < a.length - 1; i++){
            System.out.print(a[i] + ",");
        }
        System.out.print(a[a.length - 1] + "]");
    }
}
