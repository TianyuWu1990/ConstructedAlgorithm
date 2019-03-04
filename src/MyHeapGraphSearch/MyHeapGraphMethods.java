package MyHeapGraphSearch;

import CtCILibrary.ListNode;

import java.util.*;

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

    class TopKFrequent{
        class Pair{
            String key;
            int value;
            Pair(String key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        private Comparator<Pair> myCom = new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                if (o1.value != o2.value) {
                    return o1.value - o2.value;
                }
                return o2.key.compareTo(o1.key);
            }
        };
        public String[] TopKFrequent (String[] in, int k) {
            if (k == 0) return new String[0];
            HashMap<String, Integer> map = new HashMap<>();
            for (String s : in) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
            PriorityQueue<Pair> queue = new PriorityQueue<>(k, myCom);
            for (String s : map.keySet()) {
                Pair min = queue.peek();
                Pair newPair = new Pair(s, map.get(s));
                if (queue.size() < k) {
                    queue.add(newPair);
                } else if (myCom.compare(newPair, min) > 0) {
                    queue.poll();
                    queue.add(newPair);
                }
            }
            String[] ans = new String[k];
            for (int i = k - 1; i >= 0; i--) {
                ans[i] = Objects.requireNonNull(queue.poll()).key;
            }
            return ans;
        }


    }

    class TopKFrequentII{
        private Map<String, Integer> map = null;
        private NavigableSet<String> set = null;
        private int k;

        private Comparator<String> myCom = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                int left_count = map.get(o1);
                int right_count = map.get(o2);
                if (left_count != right_count) {
                    return right_count - left_count;
                }
                return o1.compareTo(o2);
            }
        };
        public TopKFrequentII(int k) {
            this.k = k;
            map = new HashMap<>();
            set = new TreeSet<>(myCom);
        }
        public void add(String s) {
            if (map.containsKey(s)) {
                if (set.contains(s)) {
                    set.remove(s);
                }
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
            set.add(s);
            if (set.size() > k) {
                set.pollLast();
            }
        }
        public List<String> topk() {
            List<String> ans = new ArrayList<>();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                ans.add(str);
            }
            return ans;
        }
    }
}
