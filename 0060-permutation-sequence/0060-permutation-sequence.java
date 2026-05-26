class Solution {
    public String getPermutation(int n, int k) {
        int arr[]=new int[n];
        boolean vis[]=new boolean[n];  
        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        helper(arr,k,vis,ll,ans);
        Collections.sort(ans, (a,b) -> a.get(0) - b.get(0));
        StringBuilder s=new StringBuilder("");
        List<Integer> l=ans.get(k-1);
        for(int i=0;i<l.size();i++){
            s.append(l.get(i));
        }
        return s.toString();
    }
    public void helper(int arr[],int k,boolean vis[],List<Integer>ll,List<List<Integer>>ans){
      if(ll.size()==arr.length){
        ans.add(new ArrayList<>(ll));
        return;
      }

        for(int i=0;i<arr.length;i++){
            if(vis[i]==false){
                ll.add(arr[i]);
                vis[i]=true;
                helper(arr,k,vis,ll,ans);
                ll.remove(ll.size()-1);
                vis[i]=false;
            }
        }
    }
}