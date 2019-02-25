import CtCILibrary.AssortedMethods;
import CtCILibrary.ListNode;
import LinkedList.MyLinkedListMethods;
import Sorting.MergeSort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//        cache.put(1,1);
//        cache.put(2,2);
//        cache.put(3,3);
////        System.out.println(cache.get(1));
////        System.out.println(cache.get(2));
//        cache.toString();
//        System.out.println(cache.get(1));

//        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
//        Diagonal di = new Diagonal();
//        System.out.println(di.findDiagonalOrder(matrix));

//        ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> l1 = new ArrayList<Integer>();
//        l1.add(1);
//        l1.add(2);
//        System.out.println(l1);
//        l.add(l1);
//        System.out.println(l);
//        Stack_ArrayList st = new Stack_ArrayList();
//        st.push(1);
//        System.out.println(st.top());
//        Stack_twoQueue st = new Stack_twoQueue();
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        System.out.println(st.top());
//        System.out.println(st.top());
//        Queue_LinkedList q = new Queue_LinkedList();
//        Queue_LinkedList q = new Queue_LinkedList();
//        q.enqueue(1);
//        q.enqueue(2);
//        q.enqueue(3);
//        QueueListNode ListNode = q.dummy.next;
//        System.out.println(ListNode.printForward());

//        String s = "public int[] moveZero(int[] array) { if (array == null || array.length <= 1) { return array; } int left = 0; int right = array.length ‑ 1; while (left <= right) { if (array[left] != 0) { left++; } else if (array[right] == 0) { right‑‑; } else { swap(array, left++, right‑‑); }\n" +
//                "\n" +
//                "} return array;\n" +
//                "\n" +
//                "}\n" +
//                "\n" +
//                "private void swap(int[] array, int a, int b) { int tmp = array[a]; array[a] = array[b]; array[b] = tmp; }";
//        System.out.println(RemoveUniHiden.replace(s));

//        ListListNode one = new ListListNode(1);
//        ListListNode two = new ListListNode(2);
//        ListListNode thr = new ListListNode(3);
//        ListListNode fou = new ListListNode(4);
//        ListListNode fiv = new ListListNode(5);
//
//        thr.next = one;
//        one.next = fou;
//        fou.next = two;
//        two.next = fiv;
//        System.out.println(thr.printForward());
//        MyLinkedListMethods test = new MyLinkedListMethods();
//        ListListNode res = test.mergeSort(thr);
//
//        System.out.println(res.printForward());

//        ListNode h1 = AssortedMethods.createLinkedListFromArray(new int[]{6,5,4,3});
//        ListNode h2 = AssortedMethods.createLinkedListFromArray(new int[]{9,6,3});
//        MyLinkedListMethods mylist = new MyLinkedListMethods();
//        System.out.println(mylist.addTwoNumbers2(h1, h2).printForward());

        System.out.println("\\\\");
        String path = "/Users/wutianyu/Documents/ConstructedAlgorithm/src/test.txt";
        FileInputStream rd = new FileInputStream(path);
        int i;
        try {
            while((i = rd.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
