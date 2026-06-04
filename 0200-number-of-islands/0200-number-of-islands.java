
class Solution {
    public int numIslands(char[][] grid) {
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                    dfs(i,j,vis,grid,grid.length,grid[0].length);
                    c++;
                }
            }
        }
        return c;
       
    }
    public void dfs(int i,int j,boolean vis[][],char grid[][],int n,int m){
        
        if(i < 0 || i >= grid.length ||
           j < 0 || j >= grid[0].length ||
           vis[i][j] ||
           grid[i][j] == '0') {
            return;
        }
        vis[i][j]=true;
        
        dfs(i+1,j,vis,grid,n,m);
        dfs(i-1,j,vis,grid,n,m);
        dfs(i,j+1,vis,grid,n,m);
        dfs(i,j-1,vis,grid,n,m);
        
    }
}
