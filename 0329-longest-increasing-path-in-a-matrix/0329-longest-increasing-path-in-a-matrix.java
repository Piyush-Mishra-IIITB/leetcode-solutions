class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans, helper(i,j,matrix,dp,-1));
            }
        }

        return ans;
    }

    public int helper(int i,int j,int[][] arr,int[][] dp,int past){
        int n = arr.length;
        int m = arr[0].length;

        if(i<0 || i>=n || j<0 || j>=m || arr[i][j] <= past){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int a = helper(i+1,j,arr,dp,arr[i][j]);
        int b = helper(i-1,j,arr,dp,arr[i][j]);
        int c = helper(i,j+1,arr,dp,arr[i][j]);
        int d = helper(i,j-1,arr,dp,arr[i][j]);

        return dp[i][j] =
            1 + Math.max(Math.max(a,b), Math.max(c,d));
    }
}