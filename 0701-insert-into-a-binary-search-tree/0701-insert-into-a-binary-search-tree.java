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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode new_node = new TreeNode(val);
        if(root == null) return new_node;
        return helper(root,new_node);

    }
    public TreeNode helper(TreeNode root,TreeNode newNode){
        if(root.val>newNode.val && root.left==null){
            root.left=newNode;
            return root;
        }
        else if(root.val<newNode.val && root.right==null){
            root.right=newNode;
            return root;
        }
        if(root.val>newNode.val){
            root.left=helper(root.left,newNode);
        }
        else{
            root.right=helper(root.right,newNode);
        }
        return root;
    }
}