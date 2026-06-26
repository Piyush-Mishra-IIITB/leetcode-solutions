class Solution {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(m,n,0,0);
    }
    public int helper(int m,int n,int i,int j){
        if(i<0 || i>=m||j<0||j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int a=helper(m,n,i+1,j);
        int b=helper(m,n,i,j+1);
        return dp[i][j]=a+b;

    }
}