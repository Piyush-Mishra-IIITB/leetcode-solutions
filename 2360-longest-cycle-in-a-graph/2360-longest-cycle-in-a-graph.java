class Solution {
    int ans=-1;
    public int longestCycle(int[] edges) {
        int n=edges.length;
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a=edges[i];
            if(a==-1){
                continue;
            }
            adj.get(i).add(a);
        }
   boolean vis[]=new boolean[n];
   boolean pathvis[]=new boolean[n];
   int depth[]=new int[n];
   for(int i=0;i<n;i++){
    if(vis[i]==false){
        helper(vis,pathvis,i,adj,depth,1);
    }
   }
   return ans;
}
public void  helper(boolean vis[],boolean pathvis[],int i,List<List<Integer>>adj,int depth[],int level){
     vis[i]=true;
     pathvis[i]=true;
     depth[i]=level;
     for(Integer it:adj.get(i)){
        if(vis[it]==false){
            helper(vis,pathvis,it,adj,depth,level+1);
        }
        if(pathvis[it]==true && vis[it]==true){
           ans=Math.max(level-depth[it]+1,ans);
        }
     }
     pathvis[i]=false;
}}