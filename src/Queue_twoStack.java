import java.util.Stack;

public class Queue_twoStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue_twoStack() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    private void stack2ToStack1() {
        while (! stack2.empty()) {
            stack1.push(stack2.peek());
            stack2.pop();
        }
    }

    public void push(int number) {
        stack2.push(number);
    }

    public int pop() {
        if (stack1.empty() == true) {
            this.stack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.empty() == true) {
            this.stack2ToStack1();
        }
        return stack1.peek();
    }
}
