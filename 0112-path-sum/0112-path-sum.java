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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return helper(root,0,targetSum);
    }
    public boolean helper(TreeNode root,int currSum,int target){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            int newSum=currSum+root.val;
             return newSum==target;
        }
        int newSum=currSum+root.val;
        boolean l=helper(root.left,newSum,target);
        boolean r=helper(root.right,newSum,target);
        return l||r;
    }
}