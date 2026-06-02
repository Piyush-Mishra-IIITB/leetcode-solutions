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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>qq=new LinkedList<>();
        qq.add(root);
        boolean past=false;
        while(!qq.isEmpty()){
            int size=qq.size();
            for(int i=0;i<size;i++){
                TreeNode curr=qq.poll();
                if(curr==null){
                    past=true;
                }
                if(curr!=null && past==true){
                    return false;
                }
                if(curr!=null){
                   qq.add(curr.left);
                   qq.add(curr.right);
                }
                
            }
        }
        return true;
    }
}