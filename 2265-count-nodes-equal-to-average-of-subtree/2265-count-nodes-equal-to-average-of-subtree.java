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
    int output=0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return output;
    }
    public void helper(TreeNode root){
        
        int s=sum(root);
        int l=length(root);
        if(l==0){
            return;
        }
        if(s/l==root.val){
            output++;
        }
        helper(root.left);
        helper(root.right);
    }
    public int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=sum(root.left);
        int rh=sum(root.right);
        return lh+rh+root.val;
    }
    public int length(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=length(root.left);
        int rh=length(root.right);
        return lh+rh+1;
    }
}