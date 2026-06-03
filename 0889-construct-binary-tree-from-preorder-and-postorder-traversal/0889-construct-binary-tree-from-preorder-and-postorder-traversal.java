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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            hm.put(postorder[i],i);
        }
        return solve(0,preorder.length-1,0,preorder,postorder,hm);
    }
    public TreeNode solve(int ps,int pe,int pss,int preorder[],int postorder[],HashMap<Integer,Integer>hm){
         if(ps>pe){
            return null;
         }
         
         TreeNode root=new TreeNode(preorder[ps]);
         if(ps==pe){
            return root;
         }
         int index=hm.get(preorder[ps+1]);
         int num=index-pss+1;
         root.left=solve(ps+1,ps+num,pss,preorder,postorder,hm);
         root.right=solve(ps+num+1,pe,index+1,preorder,postorder,hm);
         return root;
    }
}