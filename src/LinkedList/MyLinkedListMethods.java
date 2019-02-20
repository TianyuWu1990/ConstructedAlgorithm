package LinkedList;

import CtCILibrary.ListNode;

import java.util.List;

public class MyLinkedListMethods {
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseLinkedListI(ListNode head) {
        // be careful about the base case, // need to make sure the later head.next.next != null.
        if (head == null || head.next == null) { return head; }
        ListNode newHead = reverseLinkedListI(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode insert2Sorted(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        // 1. determine if the inserted node is before head.

        if (head == null || head.value >= value) {
            newNode.next = head; return newNode;
        }
        // 2. insert the new node to the right position.

        // using the previous node to traverse the linked list // the insert position           of the new node should be between prev and // prev.next
        ListNode prev = head;
        while (prev.next != null && prev.next.value < value) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }

    public ListNode MergeTwoSorted (ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null || two != null) {
            if (one.value <= two.value) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }
        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1-> N3 -> Nn-2 -> … -> null
     */
    public ListNode reorderList (ListNode head) {
        if (head == null || head.next == null) return head;
        //1. find mid
        ListNode mid = middleNode(head);
        ListNode one = head;
        ListNode two = mid.next;
        // de-link the second half
        mid.next = null;
        //2. reverse the second half
        //3. merge two halves
        return merge(one, reverseLinkedList(two));
    }

    public ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }
        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }

    public ListNode partitionList(ListNode head, int target) {
        if (head == null || head.next == null) return head;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;
        // 1. partition into two linked list
        while (head != null) {
            if (head.value < target) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        // 2. connect two list
        curSmall.next = large.next;
        // 3. disconnect large's tail to avoid loop
        curLarge.next = null;
        return small.next;
    }


    public ListNode mergeSort (ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = middleNode(head);
        ListNode nextofmiddle = middle.next;
        middle.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextofmiddle);
        return helper(left, right);

    }
    private ListNode helper (ListNode one, ListNode two) {
        ListNode res = null;
        if (one == null) return two;
        if (two == null) return one;
        if (one.value <= two.value) {
            res = one;
            res.next = helper(one.next, two);
        } else {
            res = two;
            res.next = helper(one, two.next);
        }
        return res;
    }

    /**
     * Input:
     First List: 5->6->3  // represents number 365
     Second List: 8->4->2 //  represents number 248
     Output
     Resultant list: 3->1->6  // represents number 613
     * @param a
     * @param b
     * @return
     */
    public ListNode addTwoNumbers (ListNode a, ListNode b) {
        ListNode dummy = null;
        ListNode pre = null;
        ListNode temp = null;
        int carry = 0, sum;
        while (a != null || b != null) {
            sum = carry + (a == null ? 0 : a.value) + (b == null ? 0 : b.value);
            carry = (sum > 9 ? 1 : 0);
            sum = sum % 10;
            temp = new ListNode(sum);
            if (dummy == null) {
                dummy.next = temp;
            } else {
                pre.next = temp;
            }
            pre = temp;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        if (carry > 0) temp.next = new ListNode(carry);
        return dummy;
    }

     /*
     Input:
  First List: 5->6->3  // represents number 563
  Second List: 8->4->2 //  represents number 842
Output
  Resultant list: 1->4->0->5  // represents number 1405
      */
     ListNode res = null;
     int carry = 0;
     ListNode dif_mark = null;
     public ListNode addTwoNumbers2 (ListNode a, ListNode b) {
         if (a == null) {
             res = b;
         }
         if (b == null) {
             res = a;
         }
         int sizea = getSize(a);
         int sizeb = getSize(b);
         if (sizea == sizeb) {
             addSameSize(a, b);
         } else {
             if (sizea < sizeb) {
                 ListNode temp = a;
                 a = b;
                 b = temp;
             }
             int diff = Math.abs(sizea - sizeb);
             ListNode temp = a;
             while (diff-- >= 0) {
                 dif_mark = temp;
                 temp = temp.next;
             }
             addSameSize(dif_mark, b);
             propogateCarry(a);
         }
         if (carry > 0) {
             ListNode newnode = new ListNode(carry);
             newnode.next = res;
             res = newnode;
         }
         return res;
     }

     private void propogateCarry(ListNode head) {
         if (head != dif_mark) {
             propogateCarry(head.next);
             int sum = carry + head.value;
             carry = sum / 10;
             sum = sum % 10;
             ListNode newnode = new ListNode(sum);
             newnode.next = res;
             res = newnode;
         }
     }

     private void addSameSize(ListNode a, ListNode b) {
         if (a == null) return;
         addSameSize(a.next, b.next);
         int sum = a.value + b.value + carry;
         carry = sum / 10;
         sum = sum % 10;
         ListNode newnode = new ListNode(sum);
         newnode.next = res;
         res = newnode;
     }

     private int getSize(ListNode head) {
         int size = 0;
         while (head != null) {
             size++;
             head = head.next;
         }
         return size;
     }
}




