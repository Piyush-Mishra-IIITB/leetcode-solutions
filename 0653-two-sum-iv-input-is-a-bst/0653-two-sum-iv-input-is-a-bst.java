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
    public boolean findTarget(TreeNode root, int k) {
      List<Integer>ll=new ArrayList<>();
      helper(ll,root);
      HashMap<Integer,Integer>hm=new HashMap<>();
      for(int i=0;i<ll.size();i++){
         int find=k-ll.get(i);
         if(hm.containsKey(find)){
            return true;
         }
         hm.put(ll.get(i),1);
      }
      return false;
    }       
    public void helper(List<Integer>ll,TreeNode root){
        if(root==null){
            return;
        }
        helper(ll,root.left);
        ll.add(root.val);
        helper(ll,root.right);
    }
}