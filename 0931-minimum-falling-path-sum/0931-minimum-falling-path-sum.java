class Solution {
    Integer dp[][];
    public int minFallingPathSum(int[][] matrix) {
        int output=Integer.MAX_VALUE;
        int n=matrix.length;
        int m=matrix[0].length;
        dp=new Integer[n][m];
        for(int i=0;i<matrix[0].length;i++){
            int ans=helper(0,i,matrix,matrix.length,matrix[0].length);
            output=Math.min(ans,output);
        }
      return output;
    }
    public int helper(int i,int j,int matrix[][],int n,int m){
        if(j<0||j>=m){
            return Integer.MAX_VALUE;
        }
        if(i==n-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int a=helper(i+1,j,matrix,n,m);
        int b=helper(i+1,j-1,matrix,n,m);
        int c=helper(i+1,j+1,matrix,n,m);
        return dp[i][j]=matrix[i][j]+Math.min(Math.min(a,b),c);
    }
}