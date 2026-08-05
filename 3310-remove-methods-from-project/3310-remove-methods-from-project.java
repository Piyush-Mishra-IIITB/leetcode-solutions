class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<invocations.length;i++){
            int a[]=invocations[i];
            int u=a[0];
            int v=a[1];
            adj.get(u).add(v);
        }
        boolean vis[]=new boolean[n];
        dfs(vis,adj,k);
        int length=0;
        for(int i=0;i<vis.length;i++){
            if(vis[i]==true){
                length++;
            }
        }
        for(int i=0;i<vis.length;i++){
            if(vis[i]==false){
                helper(vis,adj,i);
            }
        }
        int length2=0;
        for(int i=0;i<vis.length;i++){
            if(vis[i]==true){
                length2++;
            }
        }
       
        
        List<Integer>ll=new ArrayList<>();
        for(int i=0;i<vis.length;i++){
           if(vis[i]==false){
            ll.add(i);
           }
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(i);
        }
       return length==length2 ? ll:ans;
    }
    public void helper(boolean vis[],List<List<Integer>>adj,int curr){
        if(vis[curr]){
            vis[curr]=false;
        }
        for(Integer c:adj.get(curr)){
            if(vis[c]==true){
                helper(vis,adj,c);
            }
        }
    }
    public void dfs(boolean vis[],List<List<Integer>>adj,int k){
        vis[k]=true;
        for(Integer it:adj.get(k)){
            if(vis[it]==false){
                dfs(vis,adj,it);
            }
        }
    }
}