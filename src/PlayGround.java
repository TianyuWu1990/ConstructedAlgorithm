import java.util.*;
import java.util.stream.Stream;

class PlayGround {
    public int[] mergeSort(int[] in) {
        if (in == null) return null;
        int[] res = new int[in.length];

        helper(in, res, 0, in.length - 1);
        return in;
    }

    private void helper(int[] in, int[] res, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        helper(in, res, left, mid);
        helper(in, res, mid + 1, right);
        sort(in, res, left, mid, right);
    }

    private void sort(int[] in, int[] res, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            res[i] = in[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (res[leftIndex] <= res[rightIndex]) {
                in[left++] = res[leftIndex++];
            } else {
                in[left++] = res[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            in[left++] = res[leftIndex++];
        }
    }
}
