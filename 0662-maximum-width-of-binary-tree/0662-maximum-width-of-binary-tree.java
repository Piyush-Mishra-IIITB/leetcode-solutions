
 
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
           int val=0;
           int last=0;
           for(int i=0;i<size;i++){
               pair p=qq.poll();
               TreeNode r=p.root;
               int ind=p.index;
               if(i==0){
                val=ind;
               }
               if(i==size-1){
                last=ind-val;
               }
               if(r.left!=null){
                 qq.add(new pair(r.left,2*ind+1));
               }
               if(r.right!=null){
                qq.add(new pair(r.right,2*ind+2));
               }
               max=Math.max(max,last+1);
           }
       }
       return max;
    }
}