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
    public TreeNode convertBST(TreeNode root) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        List<Integer>ll=new ArrayList<>();
        inorder(ll,root);
        int sum=0;
        for(int i=ll.size()-1;i>=0;i--){
              sum+=ll.get(i);
              hm.put(ll.get(i),sum);
        }
        dfs(hm,root);
        return root;
    }
    public void dfs(HashMap<Integer,Integer>hm,TreeNode root){
        if(root==null){
            return ;
        }
        int val=hm.get(root.val);
        root.val=val;
        dfs(hm,root.left);
        dfs(hm,root.right);
    }
    public void inorder(List<Integer>ll,TreeNode root){
        if(root==null){
            return;
        }
        inorder(ll,root.left);
        ll.add(root.val);
        inorder(ll,root.right);
    }
}