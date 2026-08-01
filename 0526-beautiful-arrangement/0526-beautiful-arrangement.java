class Solution {
    public int countArrangement(int n) {
        int arr[]=new int[n];

        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        List<Integer>ll=new ArrayList<>();
        boolean vis[]=new boolean[n];
        return helper(0,arr,ll,vis);
    }
    public int helper(int ind,int arr[],List<Integer>ll,boolean vis[]){
        if(ind==arr.length){
               return 1;
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(vis[i]==false && (arr[i] % (ind+1) == 0 || (ind+1) % arr[i] == 0)){
                vis[i]=true;
                ll.add(arr[i]);
                ans+=helper(ind+1,arr,ll,vis);
                ll.remove(ll.size()-1);
                vis[i]=false;
            }
            
        } 
        return ans;  
     }

    
}