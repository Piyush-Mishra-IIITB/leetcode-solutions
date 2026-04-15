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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode>l1=new ArrayList<>();
         List<TreeNode>l2=new ArrayList<>();
         helper(l1,root1);
         helper(l2,root2);
         if(l1.size()!=l2.size()){
            return false;
         }
         int length=l1.size();
         for(int i=0;i<length;i++){
            if(l1.get(i).val!=l2.get(i).val){
                return false;
            }
         }
         return true;
    }
    public void helper(List<TreeNode>ll,TreeNode root){
        if(root==null){
            return;
        }
        if(root.left ==null && root.right ==null){
            ll.add(root);
            return;
        }
        helper(ll,root.left);
        helper(ll,root.right);
    }
}