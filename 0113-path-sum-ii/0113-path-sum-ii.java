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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        helper(targetSum,root,ll,ans,0);
        return ans;
    }
    public void helper(int target,TreeNode root,List<Integer>var,List<List<Integer>>ans,int sum){
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null){
           
            if(root.val+sum==target){
                var.add(root.val);
                ans.add(new ArrayList<>(var));
                var.remove(var.size()-1);
                return;
            }
        }
        var.add(root.val);
        helper(target,root.left,var,ans,sum+root.val);
        helper(target,root.right,var,ans,sum+root.val);
        var.remove(var.size()-1);
    }
}