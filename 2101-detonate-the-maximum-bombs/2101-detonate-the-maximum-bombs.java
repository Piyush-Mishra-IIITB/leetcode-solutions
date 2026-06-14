class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>>adj=new ArrayList<>();
        int n=bombs.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            long u=bombs[i][0];
            long v=bombs[i][1];
            long r=bombs[i][2];
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                long u2=bombs[j][0];
                long v2=bombs[j][1];
                long dx=u2-u;
                long dy=v2-v;
                long dist=dx*dx+dy*dy;
                if(dist<=r*r){
                    adj.get(i).add(j);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            boolean vis[]=new boolean[n];
            int a=dfs(i,vis,adj);
            max=Math.max(a,max);
        }
        return max;
    }
    public int dfs(int i,boolean vis[],List<List<Integer>>adj){
        vis[i]=true;
        int a=1;
        for(Integer it:adj.get(i)){
            if(vis[it]==false){
                a+=dfs(it,vis,adj);
            }
        }
        return a;
    }
}