class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        boolean vis[]=new boolean[n];
        int group=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(i,vis,stones);
                group++;
            }
        }
        
        return n-group;
    }
    public void dfs(int ind,boolean vis[],int stones[][]){
        int n=stones.length;
        vis[ind]=true;
        for(int i=0;i<n;i++){
          if((vis[i]==false)&& (stones[ind][0]==stones[i][0]|| stones[ind][1]==stones[i][1])){
            dfs(i,vis,stones);
          }
        }
    }
}