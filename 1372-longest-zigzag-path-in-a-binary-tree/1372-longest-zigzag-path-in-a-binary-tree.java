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
    public int longestZigZag(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root,true,0);
        helper(root,false,0);
        return sum;
    }  
    public void helper(TreeNode root,boolean vis,int steps){
        if(root==null){
            return;
        }
        sum=Math.max(sum,steps);
        if(vis){
            helper(root.left,false,steps+1);
            helper(root.right,true,1);
        }else{
            helper(root.right,true,steps+1);
            helper(root.left,false,1);
        }
    }
}