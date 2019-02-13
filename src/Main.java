import Sorting.MergeSort;

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

//        String s = "// Method 1: recursion, this method will timeout on laicode.com public long fibonacci(int K) { if (K <= 0) { return 0; } if (K == 1) { return 1; } return fibonacci(K ‑ 1) + fibonacci(K ‑ 2);\n" +
//                "\n" +
//                "}\n" +
//                "\n" +
//                "// Method 2: dp solution with O(n) space. public long fibonacciI(int K) {\n" +
//                "\n" +
//                "if (K <= 0) { return 0; } long[] array = new long[K + 1]; array[1] = 1; for (int i = 2; i <= K; i++) {\n" +
//                "\n" +
//                "array[i] = array[i ‑ 2] + array[i ‑ 1]; } return array[K];\n" +
//                "\n" +
//                "}\n" +
//                "\n" +
//                "// Method 3: dp solution with O(1) space. public long fibonacciII(int K) {\n" +
//                "\n" +
//                "long MergeSort2 = 0; long b = 1; if (K <= 0) {\n" +
//                "\n" +
//                "return MergeSort2; } while (K > 1) {\n" +
//                "\n" +
//                "long temp = MergeSort2 + b;\n" +
//                "\n" +
//                "MergeSort2 = b;\n" +
//                "\n" +
//                "b = temp;\n" +
//                "\n" +
//                "K‑‑; } return b;\n" +
//                "\n" +
//                "ﬁle:///Users/wutianyu/Desktop/2018%20%E5%86%AC%E5%AD%A31%E7%8F%AD%20%E7%B3%BB%E7%BB%9F%E7%8F%ADJava%20Solution%20I%…\n" +
//                "\n" +
//                "13/75 2/7/2019\n" +
//                "\n" +
//                "2018 冬季1班 系统班Java Solution I - Google 文档\n" +
//                "\n" +
//                "}\n" +
//                "\n" +
//                "// Method 4: O(logn) solution using matrix multiplication.\n" +
//                "\n" +
//                "// M = {{1, 1}, {1, 0}} = {{f(2), f(1)}, {f(1), f{0}}} // fibo(K) = (M ^ K)[0][0] public static final long[][] SEED = { { 1L, 1L }, { 1L, 0L } };\n" +
//                "\n" +
//                "public long fibonacciIII(int K) {\n" +
//                "\n" +
//                "if (K <= 0) { return 0; } if (K == 1) {\n" +
//                "\n" +
//                "return 1; } long[][] matrix = { { 1L, 1L }, { 1L, 0L } }; pow(matrix, K ‑ 1); return matrix[0][0];\n" +
//                "\n" +
//                "}\n" +
//                "\n" +
//                "// calculate matrix ^ pow, and use the result to update matrix value. private void pow(long[][] matrix, int pow) {\n" +
//                "\n" +
//                "if (pow == 1) { return; } pow(matrix, pow / 2); multiply(matrix, matrix); if (pow % 2 != 0) {\n" +
//                "\n" +
//                "multiply(matrix, SEED); }\n" +
//                "\n" +
//                "}\n" +
//                "\n" +
//                "// matrix multiplication and the result is updated to matrix itself.\n" +
//                "\n" +
//                "private void multiply(long[][] matrix, long[][] multiplier) { long topLeft = matrix[0][0] * multiplier[0][0] + matrix[0][1] * multiplier[1][0]; long topRight = matrix[0][0] * multiplier[0][1] + matrix[0][1] * multiplier[1][1]; long bottomLeft = matrix[1][0] * multiplier[0][0] + matrix[1][1] * multiplier[1][0]; long bottomRight = matrix[1][0] * multiplier[0][1] + matrix[1][1] * multiplier[1][1]; matrix[0][0] = topLeft; matrix[0][1] = topRight; matrix[1][0] = bottomLeft; matrix[1][1] = bottomRight; } }";
//        System.out.println(RemoveUniHiden.replace(s));

    }
}
