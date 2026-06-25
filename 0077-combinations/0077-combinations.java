class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        helper(n,1,ll,ans,k);
        return ans;
    }
    public void helper(int n,int i,List<Integer>ll,List<List<Integer>>ans,int k){
        
        if(ll.size()==k){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(i>n){
            return;
        }
       ll.add(i);
       helper(n,i+1,ll,ans,k);
       ll.remove(ll.size()-1);
       helper(n,i+1,ll,ans,k);
    }

}