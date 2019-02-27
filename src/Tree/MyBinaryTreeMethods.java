package Tree;

import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MyBinaryTreeMethods {
    public List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) return preorder;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {

        }
    }
}
