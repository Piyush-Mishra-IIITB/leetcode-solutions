
class Solution {
    public boolean hasPathSum(TreeNode root, int target) {
        List<List<Integer>>adj=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        helper(adj,ll,root);
        for(int i=0;i<adj.size();i++){
            List<Integer>l=adj.get(i);
            int sum=0;
            for(int j=0;j<l.size();j++){
                 sum+=l.get(j);
            }
            if(sum==target){
                return true;
            }
        }
        return false;
    }
    public void helper(List<List<Integer>>adj,List<Integer>ll,TreeNode root){
        if(root==null){
            return;
        }
        ll.add(root.val);
        if(root.left==null && root.right==null){
            adj.add(new ArrayList<>(ll));
            ll.remove(ll.size()-1);
            return;
        }
        helper(adj,ll,root.left);
        helper(adj,ll,root.right);
        ll.remove(ll.size()-1);
    }
}