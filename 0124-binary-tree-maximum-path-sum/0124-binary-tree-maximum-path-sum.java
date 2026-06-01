class Solution {
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
          if(root==null){
              return 0;
          }
          helper(root);
          return sum;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=Math.max(0,helper(root.left));
        int rh=Math.max(0,helper(root.right));
        sum=Math.max(sum,lh+rh+root.val);
        return Math.max(lh,rh)+root.val;
    }
}