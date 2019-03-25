package DFS;

import CtCILibrary.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyBackTrackingMethods {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n && k <= n - i + 1;i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }

    // no duplicates
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums);
        // (ans, tempList, input, start index)
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        // add tempList to the ans at first or at last, depends on the order of requirement, trick: new a list to deep copy
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            // backtrack
            tempList.remove(tempList.size() - 1);
        }
        list.add(new ArrayList<>(tempList));

    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // in order to skip the duplicates in the recursion
        Arrays.sort(nums);
        backtrackI(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrackI(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
        list.add(new ArrayList<>(tempList));

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackII(list, new ArrayList<>(), nums, target, 0);
        return list;

    }

    private void backtrackII(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindrome(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

    public ArrayList<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }

        // generate all possible root
        // n is 1-based
        return helper(1,n);
    }

    private ArrayList<TreeNode> helper(int start, int end) {
        // the list contains all possible roots
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            // add null when theres no node available
            list.add(null);
            return list;
        }

        ArrayList<TreeNode> l_list, r_list;
        // bottom-up recursion
        for (int i = start; i <= end; i++) {
            // left contains a list of nodes that are left subtree nodes to the current
            l_list = helper(start, i - 1);
            // right contains a list of nodes that are right subtree nodes to the current
            r_list = helper(i + 1, end);
            // iterate through left subtree and right subtree to connect them to the root node
            for (TreeNode l_node : l_list) {
                for (TreeNode r_node : r_list) {
                    TreeNode root = new TreeNode(i);
                    root.left = l_node;
                    root.right = r_node;
                    // list is a list of roots whos subtrees are already connected
                    list.add(root);
                }
            }
        }
        return list;
    }


    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, ans, 0, "", 0);
        return ans;
    }

    private void backtrack(String s, List<String> ans, int idx, String back, int count) {
        if (count == 4 && idx == s.length()) {
            ans.add(back);
        }
        for (int i = 1; i < 4; i++) {
            if (count > 4 || idx + i > s.length()) break;
            String seg = s.substring(idx, idx + i);
            if (seg.charAt(0) == '0' && seg.length() > 1 || i == 3 && Integer.valueOf(seg) > 255) continue;
            // avoid restore the back after backtracking
            backtrack(s, ans, idx + i, back + seg + (count == 3 ? "" : "."), count + 1);
        }
    }


}
