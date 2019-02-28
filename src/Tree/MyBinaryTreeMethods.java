package Tree;

import CtCILibrary.TreeNode;

import java.util.*;

public class MyBinaryTreeMethods {
    public List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) return preorder;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {

        }
        return preorder;
    }

    class hello implements Comparator<hello> {

        @Override
        public int compare(hello o1, hello o2) {
            return 0;
        }
    }
}
