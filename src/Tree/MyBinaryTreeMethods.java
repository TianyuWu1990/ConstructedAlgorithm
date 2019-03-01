package Tree;

import CtCILibrary.ListNode;
import CtCILibrary.TreeNode;

import java.util.*;

public class MyBinaryTreeMethods {
    public List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) return preorder;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            // the left subtree should be traversed before right subtree,
            // since stack is LIFO, we should push right into the stack first,
            // so for the next step the top element of the stack is the left
            // subtree.
            if (cur.right != null) stack.offerFirst(cur.right);
            if (cur.left != null) stack.offerFirst(cur.left);
            preorder.add(cur.value);
        }
        return preorder;
    }

    public List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // always try go to the left side to see if there is any node
            // should be traversed before the cur node, cur node is stored
            // on stack since it has not been traversed yet.
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                // if can not go left, meaning all the nodes on the left side of
                // the top node on stack have been traversed, the next traversing
                // node should be the top node on stack.
                cur = stack.pollFirst();
                inOrder.add(cur.value);
                // the next subtree we want to traverse is cur.right.
                cur = cur.right;
            }
        }
        return inOrder;
    }

    public List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if (root == null) return inOrder;
        Deque<TreeNode> preOrder = new LinkedList<>();
        preOrder.offerFirst(root);
        while (!preOrder.isEmpty()) {
            TreeNode cur = preOrder.pollFirst();
            inOrder.add(cur.value);
            if (cur.left != null) preOrder.offerFirst(cur.left);
            if (cur.right != null) preOrder.offerFirst(cur.right);
        }
        Collections.reverse(inOrder);
        return inOrder;
    }

    public boolean checkBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) != -1;
    }

    private int height (TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean checkSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.value != right.value) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean checkTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.value != two.value) {
            return false;
        }
        return checkTweakedIdentical(one.left, two.left) && checkTweakedIdentical(one.right, two.right)
                || checkTweakedIdentical(one.left, two.right) && checkTweakedIdentical(one.right, two.left);
    }

    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.value < min || root.value > max) return false;
        return isBST(root.left, min, root.value - 1) && isBST(root.right, root.value + 1, max);
    }

    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> ans = new ArrayList<>();
        getRange(root, ans, min, max);
        return ans;
    }

    private void getRange(TreeNode root, List<Integer> ans, int min, int max) {
        if (root == null) {
            return;
        }
        if (root.value > min) {
            getRange(root.left, ans, min, max);
        }
        if (root.value >= min && root.value <= max) {
            ans.add(root.value);
        }
        if (root.value < max) {
            getRange(root.right, ans, min, max);
        }
    }


}
