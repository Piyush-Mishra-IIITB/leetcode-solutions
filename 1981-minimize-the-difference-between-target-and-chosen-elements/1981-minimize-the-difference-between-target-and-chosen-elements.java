class Solution {
     Integer dp[][];
    public int minimizeTheDifference(int[][] mat, int target) {
        int sum=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                sum+=mat[i][j];
            }
        }
        dp=new Integer[mat.length][sum+1];
        return helper(0, mat, target, 0);  
    }
    public int helper(int ind, int[][] mat, int target, int sum) {

        if (ind == mat.length) {
             return (Math.abs(target - sum));
        }
        if(dp[ind][sum]!=null){
            return dp[ind][sum];
        }
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i < mat[ind].length; i++) {
           ans=Math.min(ans,helper(ind + 1, mat, target, sum + mat[ind][i]));
        }
        return dp[ind][sum]=ans;
    }
}