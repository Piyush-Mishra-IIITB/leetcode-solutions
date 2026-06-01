
class Solution {
    public boolean hasPathSum(TreeNode root, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        helper(ans,ll,root);
        for(int i=0;i<ans.size();i++){
            List<Integer>a=ans.get(i);
            int p=0;
            for(int j=0;j<a.size();j++){
              p+=a.get(j);
            }
            if(p==target){
                return true;
            }
        }
        return false;
    }
    public void helper(List<List<Integer>>ans,List<Integer>ll,TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            ll.add(root.val);
            ans.add(new ArrayList<>(ll));
            ll.remove(ll.size()-1);
            return;
        }
        ll.add(root.val);
        helper(ans,ll,root.left);
        helper(ans,ll,root.right);
        ll.remove(ll.size()-1);
    }
}