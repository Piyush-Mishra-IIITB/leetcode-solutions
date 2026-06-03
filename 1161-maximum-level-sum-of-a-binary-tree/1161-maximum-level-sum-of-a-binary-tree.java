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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>qq=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        qq.add(root);
        while(!qq.isEmpty()){
            int size=qq.size();
            List<Integer>ll=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=qq.poll();
                ll.add(curr.val);
                if(curr.left!=null){
                    qq.add(curr.left);
                }
                if(curr.right!=null){
                    qq.add(curr.right);
                }
            }
            ans.add(new ArrayList<>(ll));
        }
        int output=Integer.MIN_VALUE;
        for(int i=0;i<ans.size();i++){
            List<Integer>ll=ans.get(i);
            int sum=0;
            for(int j=0;j<ll.size();j++){
                sum+=ll.get(j);
            }
            output=Math.max(output,sum);
        }
        for(int i=0;i<ans.size();i++){
            List<Integer>ll=ans.get(i);
            int sum=0;
            for(int j=0;j<ll.size();j++){
                sum+=ll.get(j);
            }
            if(sum==output){
                return i+1;
            }
        }
        return -1;
    }
}