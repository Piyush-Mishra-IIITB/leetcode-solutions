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
   
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
       if(root1==null && root2!=null){
        return root2;
       }
       if(root1!=null && root2==null){
        return root1;
       }
       if(root1==null && root2==null){
        return null;
       }
       
    helper(root1,root2,null,true);
    return root1;
    }
    public void helper(TreeNode root1,TreeNode root2,TreeNode parent,Boolean left){
        
        if(root1==null && root2!=null){
            if(left){
                parent.left=root2;
            }else{
                parent.right=root2;
            }
            return;
       }
       if(root1!=null && root2==null){
        return ;
       }
       if(root1==null && root2==null){
        return ;
       }

        root1.val=root1.val+root2.val;
      
       helper(root1.left,root2.left,root1,true);
       helper(root1.right,root2.right,root1,false);
    }

}