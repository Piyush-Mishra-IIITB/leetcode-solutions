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
        insert(new_node, root);
        return root;
    }
    void insert(TreeNode new_node, TreeNode curr){
        if(curr.val<new_node.val && curr.right == null){
            curr.right = new_node;
            return;
        }
        if(curr.val>new_node.val && curr.left == null){
            curr.left = new_node;
            return;
        }
        if(curr.val<new_node.val){
            insert(new_node, curr.right);
            return;
        }
        insert(new_node, curr.left);
    }
}