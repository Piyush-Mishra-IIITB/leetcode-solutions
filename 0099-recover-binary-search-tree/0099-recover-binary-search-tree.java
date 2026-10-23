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
    public void recoverTree(TreeNode root) {
        List<Integer>ll=new ArrayList<>();
        helper(root,ll);
        List<Integer>lll=new ArrayList<>();
        for(int i=0;i<ll.size();i++){
            lll.add(ll.get(i));
        }
        Collections.sort(lll);
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        for(int i=0;i<ll.size();i++){
            // System.out.println(ll.get(i));
            if(ll.get(i)!=lll.get(i) && first==Integer.MAX_VALUE){
               first=ll.get(i);
               second=lll.get(i);
            }
            
        }
        System.out.println(first);
        System.out.println(second);
        helper2(root,first,second);
    }
    public void helper2(TreeNode root,int f,int s){
        if(root==null){
            return;
        }
        if(root.val==f){
            root.val=s;
        }
        else if(root.val==s){
            root.val=f;
        }
        helper2(root.left,f,s);
        helper2(root.right,f,s);
    }
    public void helper(TreeNode root,List<Integer>ll){
        if(root==null){
            return;
        }
        helper(root.left,ll);
        ll.add(root.val);
        helper(root.right,ll);
    }
}