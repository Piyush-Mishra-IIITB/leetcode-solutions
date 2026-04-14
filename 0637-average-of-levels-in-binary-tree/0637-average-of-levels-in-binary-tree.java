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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        List<List<Integer>>ll=new ArrayList<>();
        Queue<TreeNode>qq=new LinkedList<>();
        qq.add(root);
        while(!qq.isEmpty()){
            int size=qq.size();
            List<Integer>a=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=qq.poll();
                a.add(curr.val);
                if(curr.left!=null){
                    qq.add(curr.left);
                }
                if(curr.right!=null){
                    qq.add(curr.right);
                }
            }
            ll.add(new ArrayList<>(a));
        }
        for(int i=0;i<ll.size();i++){
            List<Integer>l=ll.get(i);
            Double sum=0.0;
            for(int j=0;j<l.size();j++){
                sum+=l.get(j);
            }
            ans.add(sum/l.size());
        }
        return ans;
    }
}