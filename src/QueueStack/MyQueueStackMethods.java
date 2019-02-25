package QueueStack;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueueStackMethods {
    public LinkedList SortThreeStacks(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        sort(s1, s2, s3, s1.size());
        return s1;
    }

    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int length) {
        if (length <= 1) return;
        int mid1 = length / 2;
        int mid2 = length - mid1;
        for (int i = 0; i < mid1; i++) {
            s2.offerFirst(s1.pollFirst());
        }
        sort(s2, s3, s1, mid1);
        sort(s1, s3, s2, mid2);
        int i = 0, j = 0;
        while (i < mid1 && j < mid2) {
            if (s2.peekFirst() < s1.peekFirst()) {
                s3.offerFirst(s2.pollFirst());
                i++;
            } else {
                s3.offerFirst(s1.pollFirst());
                j++;
            }
        }
        while (i < mid1) {
            s3.offerFirst(s2.pollFirst());
            i++;
        }
        while (j < mid2) {
            s3.offerFirst(s1.pollFirst());
            j++;
        }
        //elements are descending in s3, push back to s1 in ascending order
        for (int index = 0; index < length; index++) {
            s1.offerFirst(s3.pollFirst());
        }
    }

    class QueueByTwoStack {
        private LinkedList<Integer> in;
        private LinkedList<Integer> out;
        public QueueByTwoStack() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        private void move() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.offerFirst(in.pollFirst());
                }
            }
        }
        public Integer poll(){
            move();
            return out.isEmpty() ? null : out.pollFirst();
        }

        public void offer(int value) {
            in.offerFirst(value);
        }
        public Integer peek() {
            move();
            return out.isEmpty() ? null : out.peekFirst();
        }
        public int size() {
            return in.size() + out.size();
        }
        public boolean isEmpty() {
            return in.size() == 0 && out.size() == 0;
        }
    }

    class StackByTwoQueue{

    }

    class StackByOneQueue{

    }

    class StackWithMin{
        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public StackWithMin() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public Integer min() {
            if (!minStack.isEmpty()) {
                return minStack.peekFirst();
            } else {
                return null;
            }
        }

        public void push(int value) {
            stack.offerFirst(value);
            if (minStack.isEmpty() || minStack.peekFirst() >= value) {
                minStack.offerFirst(value);
            }
        }

        public Integer pop() {
            if (stack.isEmpty()) return null;
            Integer ans = stack.pollFirst();
            if (minStack.peekFirst().equals(ans)) {
                minStack.pollFirst();
            }
            return ans;
        }

        public Integer top() {
            if (stack.isEmpty()) {
                return null;
            } else {
                return stack.peekFirst();
            }
        }
    }

    class StackByDeque{

    }

    class ThreeStackRemove{

    }

}
