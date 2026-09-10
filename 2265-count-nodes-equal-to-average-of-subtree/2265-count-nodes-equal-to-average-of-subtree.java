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
    
    public int averageOfSubtree(TreeNode root) {
         if(root==null){
            return 0;
         }
         int val=helper(root);
         int totalNode=helper2(root);
         int op=0;
         if(val/totalNode==root.val){
            op++;
         }
         op+=averageOfSubtree(root.left);
         op+=averageOfSubtree(root.right);
         return op;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int lh=helper(root.left);
        int rh=helper(root.right);
        return lh+rh+root.val;
    }
    public int helper2(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int lh=helper2(root.left);
        int rh=helper2(root.right);
        return lh+rh+1;
    }
}