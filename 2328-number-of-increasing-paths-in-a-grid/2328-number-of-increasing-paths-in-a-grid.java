class Solution {
    int MOD = 1000000007;
    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long ans = 0;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = (ans + helper(i,j,grid,-1,dp)) % MOD;
            }
        }
        return (int)ans;
    }

    public int helper(int i,int j,int grid[][],int past,int dp[][]){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j] <= past){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        long count = 1;
        count = (count + helper(i+1,j,grid,grid[i][j],dp)) % MOD;
        count = (count + helper(i-1,j,grid,grid[i][j],dp)) % MOD;
        count = (count + helper(i,j+1,grid,grid[i][j],dp)) % MOD;
        count = (count + helper(i,j-1,grid,grid[i][j],dp)) % MOD;

        return dp[i][j] = (int)count;
    }
}