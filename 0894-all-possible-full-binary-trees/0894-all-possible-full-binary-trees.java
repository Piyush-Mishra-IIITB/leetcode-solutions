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
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0){
            return new ArrayList<>();
        }
        return helper(n);
        
    }
    public List<TreeNode> helper(int n){
        List<TreeNode>ans=new ArrayList<>();
        if(n==1){
            TreeNode root=new TreeNode(0);
           ans.add(root);
           return ans;
        }

        for(int i=2;i<=n;i+=2){
            int l=i-1;
            int r=n-(l+1);
            List<TreeNode>left=helper(l);
            List<TreeNode>right=helper(r);

            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    TreeNode root=new TreeNode(0);
                    root.left=left.get(j);
                    root.right=right.get(k);

                    ans.add(root);
                }
            }
        }
        return ans;
    }
}