public class QueueNode {
        public int val;
        public QueueNode next;

        public QueueNode(int value) {
            val = value;
        }
    public String printForward() {
        if (next != null) {
            return val + "->" + next.printForward();
        } else {
            return ((Integer) val).toString();
        }
    }
    }

