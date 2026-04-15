/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;

        List<Integer> ans = new ArrayList<>();
        helper(root, ans);

        Collections.sort(ans);

        int min = ans.get(0);

        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i) != min) {
                return ans.get(i);
            }
        }

        return -1;
    }

    public void helper(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        ans.add(root.val);
        helper(root.left, ans);
        helper(root.right, ans);
    }
}