public class Queue_LinkedList {



        public QueueNode dummy, tail; //head and tail node

        public Queue_LinkedList() {
            dummy = new QueueNode(-1);
            tail = dummy; //tail is head when initial
        }

        //enqueue, add MergeSort2 new node behind the tail node
        public void enqueue(int val) {
            QueueNode node = new QueueNode(val);
            tail.next = node;
            tail = node;
        }

        //dequeue, redirect dummy's next to its next.next

        public int dequeue() {
            int ele = dummy.next.val;
            dummy.next = dummy.next.next;
            //reset head and tail when remove the last element
            if (dummy.next == null) {
                tail = dummy;// reset
            }
            return ele;
        }

        public int peek() {
            int ele = dummy.next.val;
            return ele;
        }

        public boolean isEmpty() {
            return dummy.next == null;
        }

    }

