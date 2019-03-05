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

    public TreeNode BTLCA(TreeNode root, TreeNode q, TreeNode p) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(p);
        map.put(p, null);
        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
                map.put(cur.left, cur);
            }
            if (cur.right != null) {
                stack.push(cur.right);
                map.put(cur.right, cur);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (!set.contains(q)) {
            q = map.get(q);
        }
        return q;
    }

    public TreeNode BTLCArecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode ll = BTLCArecursive(root.left, p, q);
        TreeNode lr = BTLCArecursive(root.right, p, q);
        if (ll != null && lr != null) return root;
        return ll == null ? lr : ll;
    }

    public TreeNode BSTLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root.value > p.value && root.value > q.value) {
            return BSTLCA(root.left, p, q);
        } else if (root.value < p.value && root.value < q.value) {
            return BSTLCA(root.right, p, q);
        } else {
            return root;
        }
    }

    public static class MaxPathSum {
        public int maxPathSum(TreeNode root) {
            if (root == null) return 0;
            return maxPathSum(root, 0);
        }

        //method1: pass down the prefix sum
        private int maxPathSum(TreeNode root, int sum) {
            sum += root.value;
            if (root.left == null && root.right == null) {
                return sum;
            } else if (root.left == null) {
                return maxPathSum(root.right, sum);
            } else if (root.right == null) {
                return maxPathSum(root.left, sum);
            }

            return Math.max(maxPathSum(root.left, sum), maxPathSum(root.right, sum));
        }

        //method2: Bottom up return the max suffix sum
        public int maxPathSumII(TreeNode root) {
            if (root.left == null && root.right == null) {
                return root.value;
            }
            if (root.left == null) {
                return root.value + maxPathSumII(root.right);
            }
            if (root.right == null) {
                return root.value + maxPathSumII(root.left);
            }
            return root.value + Math.max(maxPathSumII(root.left), maxPathSumII(root.right));
        }

        /**
         * node to node that on the path from root to leaf
         * @return
         */
        public int maxPathSumIII(TreeNode root) {
            if (root == null) return 0;
            int[] max = new int[]{Integer.MIN_VALUE};
            helper(root, max);
            return max[0];
        }

        private int helper(TreeNode root, int[] max) {
            if (root == null) {
                return 0;
            }
            int left = helper(root.left, max);
            int right = helper(root.right, max);
            int sin = Math.max(0, Math.max(left, right)) + root.value;
            max[0] = Math.max(sin, max[0]);
            return sin;
        }

        /**
         * node to node anywhere in the tree
         * @param root
         * @return
         */
        public int maxPathSumIV(TreeNode root) {
            int[] max = new int[]{Integer.MIN_VALUE};
            helperII(root, max);
            return max[0];
        }

        private int helperII(TreeNode root, int[] max) {
            if (root == null) return 0;
            int left = helperII(root.left, max);
            int right = helperII(root.right, max);
            left = left < 0 ? 0 : left;
            right = right < 0 ? 0 : right;
            max[0] = Math.max(root.value + left + right, max[0]);
            return root.value + Math.max(left, right);
        }
    }

    public static class PathSumTarget {
        public boolean exist(TreeNode root, int sum) {
            if (root == null) return false;
            List<TreeNode> path = new ArrayList<>();
            return helper(root, path, sum);
        }

        private boolean helper(TreeNode root, List<TreeNode> path, int sum) {
            path.add(root);
            int temp = 0;
            for (int i = path.size() - 1; i >= 0; i--) {
                temp += path.get(i).value;
                if (temp == sum) {
                    return true;
                }
            }
            if (root.left != null && helper(root.left, path, sum)) {
                return true;
            }
            if (root.right != null && helper(root.right, path, sum)) {
                return true;
            }
            //clean up when return to the previous level
            path.remove(path.size() - 1);
            return false;
        }

        public boolean existII(TreeNode root, int sum) {
            if (root == null) return false;
            Set<Integer> prefixSum = new HashSet<>();
            prefixSum.add(0);
            return helperII(root, prefixSum, 0, sum);
        }

        private boolean helperII(TreeNode root, Set<Integer> prefixSum, int prevSum, int sum) {
            prevSum += root.value;
            if (prefixSum.contains(prevSum - sum)) {
                return true;
            }
            boolean needRemove = prefixSum.add(prevSum);
            if (root.left != null && helperII(root.left, prefixSum, prevSum, sum)) {
                return true;
            }
            if (root.right != null && helperII(root.right, prefixSum, prevSum, sum)) {
                return true;
            }
            if (needRemove) {
                prefixSum.remove(prevSum);
            }
            return false;
        }
    }

    public void printZigZag(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> cur_level = new LinkedList<>();
        Deque<TreeNode> next_level = new LinkedList<>();
        cur_level.push(root);
        boolean left_to_right = true;
        while (!cur_level.isEmpty()) {
            TreeNode node = cur_level.pop();
            System.out.print(node.value + " ");
            if (left_to_right) {
                if (node.left != null) {
                    next_level.push(node.left);
                }
                if (node.right != null) {
                    next_level.push(node.right);
                }
            } else {
                if (node.right != null) {
                    next_level.push(node.right);
                }
                if (node.left != null) {
                    next_level.push(node.left);
                }
            }
            if (cur_level.isEmpty()) {
                System.out.println("");
                left_to_right = !left_to_right;
                Deque<TreeNode> tmp;
                tmp = cur_level;
                cur_level = next_level;
                next_level = tmp;
            }
        }
    }

    public void printLevelOrder(TreeNode root) {
        // Base Case
        if(root == null) return;
        // Create an empty queue for level order tarversal
        Queue<TreeNode> q =new LinkedList<>();
        // Enqueue Root and initialize height
        q.add(root);
        while(true) {
            // nodeCount (queue size) indicates number of node at current level.
            int nodeCount = q.size();
            if(nodeCount == 0) break;
            // Dequeue all nodes of current level and Enqueue all nodes of next level
            while(nodeCount > 0) {
                TreeNode node = q.peek();
                System.out.print(node.value + " ");
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }
}
