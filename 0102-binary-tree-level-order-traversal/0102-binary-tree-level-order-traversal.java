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
 import java.util.*;
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode>qq=new LinkedList<>();
        qq.add(root);
        while(!qq.isEmpty()){
            int length=qq.size();
            List<Integer>ll=new ArrayList<>();
            for(int i=0;i<length;i++){
            TreeNode curr=qq.poll();
            ll.add(curr.val);
            if(curr.left!=null){
                qq.add(curr.left);
            }if(curr.right!=null){
                qq.add(curr.right);
            }
            }
            
           ans.add(new ArrayList<>(ll));
        }
    return ans;
    }
}