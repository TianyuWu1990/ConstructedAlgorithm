package Sorting;

public class SelectionSort {
    public int[] selectionSort(int[] array) {
        // check null before any other things.
        // check other conditions ‑ empty array… etc.
        if (array == null || array.length <= 1){
            return array;
        }
        for (int i = 0; i < array.length - 1; i++){
            int globMin = i;
            // find the min element in the subarray of (i, array.length ‑ 1)
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[globMin]) { globMin = j; }
            }
            swap(array, i, globMin);

        }
        return array;
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

//    1+2+3+4+..+n = n(n+1)/2 -> n^2 → O(n^2) Space = O(1)
//
//    Time = O(n^2)
//
//    selection sort is NOT stable: -1a, 4, -1b, -3 insertion sort is stable: -3 -1a 4 -1b
//
//⇒ -3 4 -1b -1a
}
