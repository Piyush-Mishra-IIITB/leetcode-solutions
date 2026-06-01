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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        
    return helper(0,inorder.length-1,inorder,0,preorder.length-1,preorder,hm);
    }
    public TreeNode helper(int is,int ie,int inorder[],int ps,int pe,int preorder[],HashMap<Integer,Integer>hm){
        if(is>ie || ps>pe){
            return null;
        }
        TreeNode root=new TreeNode(preorder[ps]);
        int index=hm.get(root.val);
        int length=(index-1-is)+1;
        root.left=helper(is,index-1,inorder,ps+1,ps+length,preorder,hm);
        root.right=helper(index+1,ie,inorder,ps+length+1,pe,preorder,hm);
        return root;
    }
}