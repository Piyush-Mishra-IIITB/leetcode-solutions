/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<TreeNode>>global;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      global=new ArrayList<>();
      List<TreeNode>ll=new ArrayList<>();
      List<TreeNode>l=new ArrayList<>();
    helper(root,p,ll);
    helper(root,q,l);
    List<TreeNode>fir=global.get(0);
    List<TreeNode>sec=global.get(1);
    TreeNode last=null;
    for(int i=0;i<Math.min(fir.size(),sec.size());i++){
       if(fir.get(i)==sec.get(i)){
        last=fir.get(i);
       }
    }
    return last;

    }
    public void helper(TreeNode root,TreeNode curr,List<TreeNode>ll){
       if(root==null){
         return;
       }
       if(root==curr){
        ll.add(root);
        global.add(new ArrayList<>(ll));
        ll.remove(ll.size()-1);
        return;
       }
       ll.add(root);
       if(root.val>curr.val){
        helper(root.left,curr,ll);
       }else{
         helper(root.right,curr,ll);
       }
       ll.remove(root);
    }
}