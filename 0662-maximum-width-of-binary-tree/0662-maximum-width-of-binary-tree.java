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
        TreeNode root;
        int index;
        public pair(TreeNode root,int index){
            this.root=root;
            this.index=index;
        }

    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int wid=0;
        Queue<pair>qq=new LinkedList<>();
        qq.add(new pair(root,0));
        while(!qq.isEmpty()){
            int size=qq.size();
            int min=qq.peek().index;
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                pair p=qq.poll();
                TreeNode curr=p.root;
                int ind=p.index-min;
                if(i==0){
                    first=ind;
                }if(i==size-1){
                    last=ind;
                }
                if(curr.left!=null){
                    qq.add(new pair(curr.left,2*ind+1));
                }
                if(curr.right!=null){
                    qq.add(new pair(curr.right,2*ind+2));
                }
                wid=Math.max(last-first+1,wid);
            }
        }
        return wid;
    }
}