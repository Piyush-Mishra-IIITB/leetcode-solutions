class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val==val){
            return root;
        }
        else if(root.val<val){
            if(root.right!=null){
                return searchBST(root.right,val);
            }else{
                return null;
            }
            
        }else{
            if(root.left!=null){
                return searchBST(root.left,val);
            }else{
                return null;
            }
        }
    }
}
