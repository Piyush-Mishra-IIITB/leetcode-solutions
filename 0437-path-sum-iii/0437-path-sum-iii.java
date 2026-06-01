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
    int no=0;
    public int pathSum(TreeNode root, int target) {
   if(root==null ){
       return 0;
   }
   helper(0,target,root);
   pathSum(root.left,target);
    pathSum(root.right,target);
   return no;
    }
   public void helper(long sum,int target,TreeNode root){
    if(root==null){
        return;
    }
    if(root.val+sum==target){
        no++;
    }
    helper(sum+root.val,target,root.left);
    helper(sum+root.val,target,root.right);
   }
}