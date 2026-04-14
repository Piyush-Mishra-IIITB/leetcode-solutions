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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       return helper(root,subRoot);
    }
    public boolean helper(TreeNode root,TreeNode com){
        if(root==null){
            return false;
        }
        if(helper2(root,com)){
              return true ;
        }
        boolean left=helper(root.left,com);
        boolean right=helper(root.right,com);
        return left|| right;
    }
    public boolean helper2(TreeNode root,TreeNode com){
        if(root==null && com==null){
            return true;
        }
        if(root==null && com!=null){
            return false;
        }
        if(root!=null && com==null){
            return false;
        }
        if(root.val!=com.val){
            return false;
        }
        
       boolean left=helper2(root.left,com.left);
       boolean right=helper2(root.right,com.right);
       return left && right;
    }
}