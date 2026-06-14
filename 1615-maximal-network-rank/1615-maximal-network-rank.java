class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int ind[]=new int[n];
        for(int i=0;i<roads.length;i++){
            int a[]=roads[i];
            int u=a[0];
            int v=a[1];
            ind[u]++;
            ind[v]++;
        }
        int ans=-1;
       for(int i=0;i<ind.length;i++){
         for(int j=i+1;j<ind.length;j++){
             if(isConnected(i,j,roads)){
               ans=Math.max(ans,ind[i]+ind[j]-1);
             }else{
                ans=Math.max(ans,ind[i]+ind[j]);
             }
         }
       }
       return ans;
    }
    public boolean isConnected(int s,int e,int roads[][]){
        for(int i=0;i<roads.length;i++){
            int a[]=roads[i];
            int u=a[0];
            int v=a[1];
            if(u==s && v==e){
                return true;
            }else if(u==e && v==s){
                return true;
            }
        }
        return false;
    }
}