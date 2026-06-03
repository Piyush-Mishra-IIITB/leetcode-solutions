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

// morris traversal
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer>ll=new ArrayList<>();
        if(root==null){
            return ll;
        }
      while(root!=null){
            if(root.left==null){
            ll.add(root.val);
            root=root.right;
        }else{
            TreeNode curr=root.left;
            TreeNode a=root;
            while(curr.right!=null){
                curr=curr.right;
            }
            curr.right=root;
            root=root.left;
            a.left=null;
        }
      } 
        return ll;

    }
   
}