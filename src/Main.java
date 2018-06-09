public class Main {


    public static void main(String[] args) {
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
        Queue_LinkedList q = new Queue_LinkedList();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        QueueNode node = q.dummy.next;
        System.out.println(node.printForward());

    }
}
