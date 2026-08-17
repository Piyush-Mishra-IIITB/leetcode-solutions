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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> qq=new LinkedList<>();
        qq.add(root);
        int no=1;
        while(!qq.isEmpty()){
            List<Integer>ll=new ArrayList<>();
            int length=qq.size();
            for(int i=0;i<length;i++){
                TreeNode curr=qq.poll();
                ll.add(curr.val);
                if(curr.left!=null){
                    qq.add(curr.left);
                }
                if(curr.right!=null){
                    qq.add(curr.right);
                }
            }
            no++;
            if(no%2==0){
                ans.add(new ArrayList<>(ll));
            }else{
                Collections.reverse(ll);
                 ans.add(new ArrayList<>(ll));
            }
        }
        return ans;
    }
}