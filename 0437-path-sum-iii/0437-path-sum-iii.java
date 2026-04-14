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
    int no = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return no;
        }

        helper(root, targetSum, 0);

        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return no;
    }

    public void helper(TreeNode root, int target, long sum){ 
        if(root == null){
            return;
        }

        if(sum + root.val == target){
            no++;
        }

        helper(root.left, target, sum + root.val);
        helper(root.right, target, sum + root.val);
    }
}