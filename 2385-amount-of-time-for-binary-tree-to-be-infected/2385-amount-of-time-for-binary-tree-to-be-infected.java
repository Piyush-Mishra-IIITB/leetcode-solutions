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
    public void markparent(HashMap<TreeNode,TreeNode>hm,TreeNode root){
        Queue<TreeNode>qq=new LinkedList<>();
        qq.add(root);
        while(!qq.isEmpty()){
            int size=qq.size();
            for(int i=0;i<size;i++){
                TreeNode curr=qq.poll();
                  if(curr.left!=null){
                    hm.put(curr.left,curr);
                    qq.add(curr.left);
                  }
                  if(curr.right!=null){
                    hm.put(curr.right,curr);
                    qq.add(curr.right);
                  }
            }
        }
    }
    public TreeNode finding(TreeNode root, int start) {

    if(root == null){
        return null;
    }
    if(root.val == start){
        return root;
    }
    TreeNode left = finding(root.left, start);
    if(left != null){
        return left;
    }
  return finding(root.right, start);
}
    public int amountOfTime(TreeNode root, int start) {
         HashMap<TreeNode,TreeNode>hm=new HashMap<>();
         markparent(hm,root);
         TreeNode st=finding(root,start);
         Queue<TreeNode>qq=new LinkedList<>();
         qq.add(st);
         HashMap<TreeNode,Boolean>hm2=new HashMap<>();
         hm2.put(st,true);
         int steps=-1;
         while(!qq.isEmpty()){
            int size=qq.size();
            steps++;
            for(int i=0;i<size;i++){
                TreeNode curr=qq.poll();
                if(curr.left!=null && hm2.containsKey(curr.left) ==false){
                    qq.add(curr.left);
                    hm2.put(curr.left,true);
                }
                if(curr.right!=null && hm2.containsKey(curr.right) ==false){
                    qq.add(curr.right);
                    hm2.put(curr.right,true);
                }
                if(hm.get(curr)!=null && hm2.containsKey(hm.get(curr)) ==false){
                    qq.add(hm.get(curr));
                    hm2.put(hm.get(curr),true);
                }
            }
         }
         return steps;
    }
}