class Solution {
    public int getMaximumGold(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int output=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean vis[][]=new boolean[n][m];
                if(grid[i][j]!=0 && vis[i][j]==false){
                    int a=helper(i,j,vis,grid);
                    output=Math.max(output,a);
                    vis[i][j]=true;
                }
            }
        }
       
         return output;
    }
    public int helper(int i,int j,boolean vis[][],int grid[][]){
        int n=grid.length;
        int m=grid[0].length;
    if(i<0 || i>=n|| j<0 || j>=m|| vis[i][j] || grid[i][j]==0){
       return 0;
    }
    vis[i][j]=true;
    int a=grid[i][j]+helper(i+1,j,vis,grid);
    int b=grid[i][j]+helper(i-1,j,vis,grid);
    int c=grid[i][j]+helper(i,j+1,vis,grid);
    int d=grid[i][j]+helper(i,j-1,vis,grid);
    int e=Math.max(a,b);
    int f=Math.max(c,d);
    vis[i][j]=false;
    return Math.max(e,f);
}}