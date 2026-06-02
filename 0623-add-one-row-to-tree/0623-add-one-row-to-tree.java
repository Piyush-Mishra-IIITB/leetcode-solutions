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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode a=new TreeNode(val);
            a.left=root;
            return a;
        }
        Queue<TreeNode>qq=new LinkedList<>();
        qq.add(root);
        int level=1;
        while(!qq.isEmpty()){
            int size=qq.size();
            
            for(int i=0;i<size;i++){
                TreeNode curr=qq.poll();
                if(level==depth-1){
                   TreeNode after=curr.left;
                   TreeNode after2=curr.right;
                   TreeNode new1=new TreeNode(val);
                   TreeNode new2=new TreeNode(val);
                   curr.left=new1;
                   new1.left=after;
                   curr.right=new2;
                   new2.right=after2;
                 }
                if(curr.left!=null){
                    qq.add(curr.left);
                }
                if(curr.right!=null){
                    qq.add(curr.right);
                }
                
            }
            level++;
        }
        return root;
    }
}