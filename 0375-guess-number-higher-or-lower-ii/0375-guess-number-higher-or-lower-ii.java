class Solution {
    Integer dp[][];
        public int getMoneyAmount(int n) {
            dp=new Integer[n+1][n+1];
        return helper(1,n);
    }
    public int helper(int st,int end){
        if(st>=end){
            return 0;
        }
         if(dp[st][end]!=null){
            return dp[st][end];
         }
        int ans=Integer.MAX_VALUE;
        for(int i=st;i<=end;i++){
            int a=i+helper(st,i-1);
            int b=i+helper(i+1,end);
            int curr=Math.max(a,b);
            ans=Math.min(ans,curr);

        }
        return dp[st][end]=ans;
    }
}