class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return helper(root);
    }

    public int helper(TreeNode root){
    if(root == null){
        return Integer.MAX_VALUE;
    }

    if(isleaf(root)){
        return 1;
    }

    int lh = helper(root.left);
    int rh = helper(root.right);

    return Math.min(lh,rh) + 1;
}

public boolean isleaf(TreeNode root){
    if(root.left==null && root.right==null){
        return true;
    }else{
        return false;
    }
}
}

