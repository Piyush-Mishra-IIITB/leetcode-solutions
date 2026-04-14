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
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return 0;
        }
        List<Integer>ans=new ArrayList<>();
        inorder(root,ans);
        int a=Integer.MAX_VALUE;
        for(int i=ans.size()-1;i>0;i--){
             a=Math.min(ans.get(i)-ans.get(i-1),a);
        }
        return a;
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