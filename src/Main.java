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
//        Queue_LinkedList q = new Queue_LinkedList();
//        q.enqueue(1);
//        q.enqueue(2);
//        q.enqueue(3);
//        QueueNode node = q.dummy.next;
//        System.out.println(node.printForward());

        String s = "class\u200B \u200BDictImpl\u200B \u200Bimplements\u200B \u200BDictionary\u200B { \n" +
                "  \u200Bprivate\u200B \u200Bint\u200B[]\u200B array; \n" +
                " \n" +
                "  \u200Bpublic\u200B \u200BDictImpl\u200B(\u200Bint\u200B[]\u200B array\u200B)\u200B { \n" +
                "    \u200Bthis\u200B.\u200Barray \u200B=\u200B array; \n" +
                "  } \n" +
                " \n" +
                "  \u200B// If the index is out of bound, null will be returned. \n" +
                "  \u200B@Override \n" +
                "  \u200Bpublic\u200B \u200BInteger\u200B \u200Bget\u200B(\u200Bint\u200B index\u200B)\u200B { \n" +
                "    \u200Bif\u200B \u200B(\u200Barray \u200B==\u200B \u200Bnull\u200B \u200B||\u200B index \u200B>=\u200B array\u200B.\u200Blength\u200B)\u200B { \n" +
                "      \u200Breturn\u200B \u200Bnull; \n" +
                "    } \n" +
                "    \u200Breturn\u200B array\u200B[\u200Bindex\u200B]; \n" +
                "  } \n" +
                " \n" +
                "  \u200B// For pretty printout. \n" +
                "  \u200B@Override \n" +
                "  \u200Bpublic\u200B \u200BString\u200B toString\u200B()\u200B { \n" +
                "    \u200Bif\u200B \u200B(\u200Barray \u200B==\u200B \u200Bnull\u200B)\u200B { \n" +
                "      \u200Breturn\u200B \u200BString\u200B.\u200BvalueOf\u200B(\u200Bnull\u200B); \n" +
                "    } \n" +
                "    \u200Bif\u200B \u200B(\u200Barray\u200B.\u200Blength \u200B<=\u200B \u200B10\u200B)\u200B { \n" +
                "      \u200Breturn\u200B \u200BArrays\u200B.\u200BtoString\u200B(\u200Barray\u200B); \n" +
                "    } \n" +
                "    \u200B// Truncate output if array is too large. \n" +
                "    \u200BStringBuilder\u200B sb \u200B=\u200B \u200Bnew\u200B \u200BStringBuilder\u200B(\u200B\"[\"\u200B); \n" +
                "    \u200Bfor\u200B \u200B(\u200Bint\u200B i \u200B=\u200B \u200B0\u200B;\u200B i \u200B<\u200B \u200B5\u200B;\u200B i\u200B++)\u200B { \n" +
                "      sb\u200B.\u200Bappend\u200B(\u200Barray\u200B[\u200Bi\u200B]).\u200Bappend\u200B(\u200B\", \"\u200B); \n" +
                "    } \n" +
                "    sb\u200B.\u200Bappend\u200B(\u200B\"......, \"\u200B); \n" +
                "    \u200Bfor\u200B \u200B(\u200Bint\u200B i \u200B=\u200B array\u200B.\u200Blength \u200B-\u200B \u200B4\u200B;\u200B i \u200B<\u200B array\u200B.\u200Blength\u200B;\u200B i\u200B++)\u200B { \n" +
                "      sb\u200B.\u200Bappend\u200B(\u200Barray\u200B[\u200Bi\u200B]); \n" +
                "      \u200Bif\u200B \u200B(\u200Bi \u200B!=\u200B array\u200B.\u200Blength \u200B-\u200B \u200B1\u200B)\u200B { \n" +
                "        sb\u200B.\u200Bappend\u200B(\u200B\", \"\u200B); \n" +
                "      } \n" +
                "    } \n" +
                "    sb\u200B.\u200Bappend\u200B(\u200B\"]\"\u200B); \n" +
                "    \u200Breturn\u200B sb\u200B.\u200BtoString\u200B(); \n" +
                "  } \n" +
                "}";
        System.out.println(RemoveUniHiden.replace(s));
    }
}
