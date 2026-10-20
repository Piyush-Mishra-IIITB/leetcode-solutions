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
    public boolean isValidBST(TreeNode root) {
        List<Integer>ll=new ArrayList<>();
        inorder(root,ll);
        List<Integer>l=new ArrayList<>();
        for(int i=1;i<ll.size();i++){
            if(ll.get(i)<=ll.get(i-1)){
                return false;
            }
        }
        return true;
        
    }
    public void inorder(TreeNode root,List<Integer>ll){
        if(root==null){
            return;
        }
        inorder(root.left,ll);
        ll.add(root.val);
        inorder(root.right,ll);

    }
}