class Solution {
    int ans=0;
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int p=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && grid[i][j]==1){
                    ans = Math.max(ans, dfs(i, j, vis, grid, n, m));
                }
            }
        }
        return ans;
    }
    public int dfs(int i,int j,boolean vis[][],int grid[][],int n,int m){
        if(i>=n || i<0 || j<0 || j>=m || grid[i][j]==0|| vis[i][j]==true){
            return 0;
        }
        vis[i][j]=true;  
        return 1+dfs(i+1,j,vis,grid,n,m)+dfs(i-1,j,vis,grid,n,m)+dfs(i,j+1,vis,grid,n,m)+dfs(i,j-1,vis,grid,n,m);
        
    }
}