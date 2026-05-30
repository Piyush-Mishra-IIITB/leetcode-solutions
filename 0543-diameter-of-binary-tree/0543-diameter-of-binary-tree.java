
class Solution {
    int sum=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
      
      if(root==null){
        return 0;
      }
      int lh=helper(root.left);
      int rh=helper(root.right);
      sum=Math.max(lh+rh,sum);
      diameterOfBinaryTree(root.left);
      diameterOfBinaryTree(root.right);
      return sum;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=helper(root.left);
        int rh=helper(root.right);
        return Math.max(lh,rh)+1;
    }
}