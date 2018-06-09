import java.util.LinkedList;
import java.util.Queue;

public class Stack_twoQueue {
    public Queue<Integer> queue1 = new LinkedList<Integer>();
    public Queue<Integer> queue2 = new LinkedList<Integer>();

    // 将queue1中元素移入queue2,留下最后一个。
    public void moveItems() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }

    // 交换两个队列
    public void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public void push(int x) {
        queue1.offer(x);
    }
//push q1 to q2 until one element left in q1,
//poll q1, swap two queues
    public void pop() {
        moveItems();
        queue1.poll();
        swapQueues();
    }
//push q1 to q2 until one element left in q1,
// save that one element,and poll q1,
//swap two queues then offer element to q1
    public int top() {
        moveItems();
        int item = queue1.poll();
        swapQueues();
        queue1.offer(item);
        return item;
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
