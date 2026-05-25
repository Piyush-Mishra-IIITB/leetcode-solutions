class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        boolean vis[]=new boolean[10];
        helper(k,n,ans,ll,n,vis);
        HashSet<List<Integer>> a=new HashSet<>();
        for(int i=0;i<ans.size();i++){
            a.add(ans.get(i));
        }
        List<List<Integer>>op=new ArrayList<>(a);
        return op;
    }
    public void helper(int k,int n,List<List<Integer>> ans,List<Integer>ll,int sum,boolean vis[]){
        if(sum<0){
            return;
        }
        if(ll.size()==k && sum==0){
            List<Integer>l=new ArrayList<>(ll);
            Collections.sort(l);
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=1;i<=9;i++){
            if(vis[i]==false){
                ll.add(i);
                vis[i]=true;
                helper(k,n,ans,ll,sum-i,vis);
                ll.remove(ll.size()-1);
                vis[i]=false;
            }
        }
    }
}