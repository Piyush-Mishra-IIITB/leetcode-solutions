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
    public class pair{
        int org;
        int newOne;
        public pair(int org,int newOne){
            this.org=org;
            this.newOne=newOne;
        }
    }
    public TreeNode convertBST(TreeNode root) {
        List<Integer>in=new ArrayList<>();
        inorder(in,root);
        // for(int i=0;i<in.size();i++){
        //        System.out.println(in.get(i));
        // }
        
        List<Integer>prefixSum=new ArrayList<>();
        int curr=0;
        for(int i=0;i<in.size();i++){
            curr+=in.get(i);
        }
        System.out.println("totalSum" + curr);
        HashMap<Integer,Integer>hm=new HashMap<>();
        int newOneSum=0;
        for(int i=0;i<in.size();i++){
            if(i>0){
                curr=curr-in.get(i-1);
            }
            int c=curr;
            System.out.println(i+"CurrSum" +c);
            hm.put(in.get(i),c);
        }
        helper(root,hm);
        return root;
    }
    public void helper(TreeNode root,HashMap<Integer,Integer>hm){
         if(root==null){
            return;
         }
         root.val=hm.get(root.val);
         helper(root.left,hm);
         helper(root.right,hm);
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