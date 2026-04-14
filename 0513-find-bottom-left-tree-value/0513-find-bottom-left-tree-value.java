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
   
    public int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<TreeNode>qq=new LinkedList<>();
        qq.add(root);
        List<List<Integer>>ans=new ArrayList<>();
        while(!qq.isEmpty()){
           List<Integer>ll=new ArrayList<>();
           int size=qq.size();
           for(int i=0;i<size;i++){
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

        List<Integer>v=ans.get(ans.size()-1);
        return v.get(0);

    }
}