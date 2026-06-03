
 
class Solution {
    public class pair{
        TreeNode root;
        int index;
        public pair(TreeNode root,int index){
            this.root=root;
            this.index=index;
        }
    }
    int max=0;
    public int widthOfBinaryTree(TreeNode root) {  
        Queue<pair>qq=new LinkedList<>();
        qq.add(new pair(root,0));
        
        while(!qq.isEmpty()){
            int size=qq.size();
            int first=0;
            int last=0;
            for(int i=0;i<size;i++){
                pair p=qq.poll();
                TreeNode curr=p.root;
                int ind=p.index;  
               if(i==0){
                first=p.index;
               }
               if(i==size-1){
                last=p.index;
               }
              if(curr.left!=null){
                qq.add(new pair(curr.left,2*ind+1));
              }
              if(curr.right!=null){
                qq.add(new pair(curr.right,2*ind+2));
              }
              
            }
             max=Math.max(max,last-first+1);
        }
        return max;  
    }
}