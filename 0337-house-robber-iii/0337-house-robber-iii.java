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
    HashMap<TreeNode,Integer>hm;
    public int rob(TreeNode root) {
        hm=new HashMap<>();
        return helper(root);

    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        if(hm.containsKey(root)){
            return hm.get(root);
        }
        int pick=root.val;
        if(root.left!=null){
            pick+=helper(root.left.left);
            pick+=helper(root.left.right);
        }if(root.right!=null){
            pick+=helper(root.right.right);
            pick+=helper(root.right.left);
        }
         int notPick=helper(root.left)+helper(root.right);
         
        hm.put(root,Math.max(pick,notPick));
         return hm.get(root);
    }
}