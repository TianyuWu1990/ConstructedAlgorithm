package QueueStack;

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueueStackMethods {
    public LinkedList SortByThreeStacks(LinkedList<Integer> s1) {
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

    public LinkedList<Integer> SortByTwoStack(LinkedList<Integer> input) {
        LinkedList<Integer> buffer = new LinkedList<>();
        while (!input.isEmpty()) {
            int temp = input.pollFirst();
            while (!buffer.isEmpty() && buffer.pollFirst() > temp) {
                input.offerFirst(buffer.pollFirst());
            }
            buffer.offerFirst(temp);
        }
        return buffer;
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
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        public StackByTwoQueue() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        public void push(int value) {
            q2.add(value);
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }
            swapName();
        }

        public void pop() {
            if (q1.isEmpty()) return;
            q1.poll();
        }

        public Integer top() {
            return q1.isEmpty() ? null : q1.peek();
        }

        private void swapName() {
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
    }

    class StackByOneQueue{
        Queue<Integer> q = new LinkedList<>();
        public void push(int value) {
            int size = q.size();
            q.add(value);
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                q.add(cur);
            }

        }

        public Integer pop() {
            return q.isEmpty() ? null : q.poll();

        }

        public Integer top() {
            return q.isEmpty() ? null : q.peek();
        }

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

    class DequeByStack{

    }

    class ThreeStackRemove{

    }

}
