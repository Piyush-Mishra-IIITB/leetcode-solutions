class Solution {
  int dp[];
    public int climbStairs(int n) {
        dp=new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i]=-1;
        }
        helper(n,0);
        return dp[0];
    }
    public int helper(int n,int i){
        
        if(i==n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        if((dp[i])!=-1){
            return dp[i];
        }

       int a= helper(n,i+1);
       int b=helper(n,i+2);
       return dp[i]=a+b;

    }
}