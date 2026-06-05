
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(grid[i][0]==1&& vis[i][0]==false ){
                dfs(i,0,vis,grid);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[0][i]==1&& vis[0][i]==false ){
                dfs(0,i,vis,grid);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[i][m-1]==1&& vis[i][m-1]==false ){
                dfs(i,m-1,vis,grid);
            }
        }
        for(int i=0;i<m;i++){
            if(grid[n-1][i]==1&& vis[n-1][i]==false ){
                dfs(n-1,i,vis,grid);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&& vis[i][j]==false){
                    count++;
                    vis[i][j]=true;
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,boolean vis[][],int grid[][]){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || i>=n ||j<0||j>=m||vis[i][j]==true|| grid[i][j]==0){
            return;
        }
        vis[i][j]=true;
        dfs(i+1,j,vis,grid);
        dfs(i-1,j,vis,grid);
        dfs(i,j+1,vis,grid);
        dfs(i,j-1,vis,grid);
    }
}