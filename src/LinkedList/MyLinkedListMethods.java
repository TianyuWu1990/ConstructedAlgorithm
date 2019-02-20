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

}




