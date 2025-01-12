public class MergeSort {
    public static void sort(int[] org) {
        if (org.length == 0)
        return;
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length -1);
    }

    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
        int mid = (lo + hi)/2;
        sort(org, aux, lo, mid);

        sort(org, aux, mid+1, hi);
        merge(org, aux, lo, mid, hi);
        }
    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for (int i = lo; i <= hi; i++) {
            aux[i] = org[i];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
        // for all indices from lo to hi
        for (int k = lo; k <= hi; k++) {
        // if i is greater than mid then
        // move the j'th item to the org array, update j
        if(i > mid) org[k] = aux[j++];
        // else if j is greate than hi then
        // move the i'th item to the org array, update i
        else if(j > hi) org[k] = aux[i++];
        // else if the i'th item is smaller than the j¨ath item,
        else if(aux[i] < aux[j])
        // move the i'th item to the org array, update i
            org[k] = aux[i++];
        else
        // move the j'th item to the org array, update j
            org[k] = aux[j++];
        }
    }
}
