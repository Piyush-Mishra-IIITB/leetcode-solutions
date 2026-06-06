class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int vis[]=new int[n];
        int pathvis[]=new int[n];
        int safe[]=new int[n];
        List<Integer>ll=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i]==0){
               isCycle(i,graph,vis,pathvis,safe);
            }
        }
        for(int i=0;i<n;i++){
            if(safe[i]==1){
                ll.add(i);
            }
        }
        return ll;
}
public boolean isCycle(int i,int graph[][],int vis[],int pathvis[],int safe[]){
    if(i>=vis.length){
        return false;
    }
    vis[i]=1;
    pathvis[i]=1;
    safe[i]=0;
    for(int it:graph[i]){
        if(vis[it]==0){
            if(isCycle(it,graph,vis,pathvis,safe)){
                return true;
            }
        }
        else if(pathvis[it]==1){
            return true;
        }
    }
    safe[i]=1;
    pathvis[i]=0;
    return false;
}

}