
class Solution {
    int sum=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
      
      if(root==null){
        return 0;
      }
      
      helper(root);
      return sum-1;
    }
    public int helper(TreeNode root){
        if(root==null){
         return 0;
      }
      int left=helper(root.left);
      int right=helper(root.right);
      sum=Math.max(sum,left+right+1);
      return Math.max(left,right)+1;
      
    }
} 