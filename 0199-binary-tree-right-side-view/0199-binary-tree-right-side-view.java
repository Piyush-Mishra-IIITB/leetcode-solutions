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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ll=new ArrayList<>();
        if(root==null){
            return ll;
        }
        HashMap<Integer,TreeNode>hm=new HashMap<>();
        Queue<pair>qq=new LinkedList<>();
        qq.add(new pair(root,0));
        while(!qq.isEmpty()){
          int size=qq.size();
           for(int i=0;i<size;i++){
              pair p=qq.poll();
              TreeNode c=p.root;
              int index=p.index;
              hm.put(index,c);
              if(c.left!=null){
                qq.add(new pair(c.left,index+1));
              }if(c.right!=null){
                qq.add(new pair(c.right,index+1));
              }
           }
        }
        
        for(int i=0;i<hm.size();i++){
            ll.add(hm.get(i).val);
        }
        return ll;
    }
}