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
    int sum=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        
        
        helper2(root);
        return sum;
        
    }
    public void helper1(TreeNode root,TreeNode child){
        if(root==null || child==null){
            return;
        }
        sum=Math.max(sum,Math.abs(root.val-child.val));
        helper1(root,child.left);
        helper1(root,child.right);
    }
    public void helper2(TreeNode root){
        if(root==null){
            return;
        }
        helper1(root,root.left);
        helper1(root,root.right);
        helper2(root.left);
        helper2(root.right);
    }
    
}