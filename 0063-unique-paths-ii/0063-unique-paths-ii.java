class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return helper(n,m,0,0,grid);
    }
    public int helper(int n,int m,int i, int j,int grid[][]){
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==1){
            return 0;
        }
        if(i==n-1 && j==m-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int a=helper(n,m,i+1,j,grid);
        int b=helper(n,m,i,j+1,grid);
        return dp[i][j]=a+b;
    }
}