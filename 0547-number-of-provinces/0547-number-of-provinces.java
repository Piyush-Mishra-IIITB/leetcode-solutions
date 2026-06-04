class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n+1];
        int provinces = 0;
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    ans.get(i).add(j);
                    ans.get(j).add(i);
                }
            }
        }
        List<Integer>ll=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i,ans,ll,vis);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int ind,List<List<Integer>>ans,List<Integer>ll,boolean vis[]){
        if(vis[ind]==false){
            ll.add(ind);
            vis[ind]=true;
        }
        List<Integer>a=ans.get(ind);
        for(int i=0;i<a.size();i++){
            if(vis[a.get(i)]==false){
                dfs(a.get(i),ans,ll,vis);
            }
        }
    }
}

