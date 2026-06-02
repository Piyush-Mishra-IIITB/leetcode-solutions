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
 */class Solution {
    long product = 0;
    int MOD = 1000000007;
    public int maxProduct(TreeNode root) {
        long totalSum = sum(root);
        helper(root, totalSum);
        return (int)(product % MOD);
    }

    public long helper(TreeNode root, long totalSum) {

        if(root == null){
            return 0;
        }
        long left = helper(root.left, totalSum);
        long right = helper(root.right, totalSum);
        long currSum = left + right + root.val;
        product = Math.max(product,currSum * (totalSum - currSum));
         return currSum;
    }

    public long sum(TreeNode root) {

        if(root == null){
            return 0;
        }
        return sum(root.left)+sum(root.right)+ root.val;
    }
}