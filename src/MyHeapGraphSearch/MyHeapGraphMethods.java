package MyHeapGraphSearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyHeapGraphMethods {
    public int[] kSmallest(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                maxheap.offer(nums[i]);
            } else if (nums[i] < maxheap.peek()) {
                maxheap.poll();
                maxheap.offer(nums[i]);
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = maxheap.poll();
        }
        return ans;
    }
}
