class Solution {
    Long dp[][];
    int mod=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        dp=new Long[n+1][target+1];
        return (int)helper(0,n,k,target,0)%mod;
    }
    public long helper(int ind,int n,int k,int target,int curr){
       
        if(ind==n){
            if(curr==target){
                return 1l;
            }
            return 0l;
        }
        if(curr>target){
            return 0l;
        }
        if(dp[ind][curr]!=null){
            return dp[ind][curr];
        }
        long ans=0;
        for(int i=1;i<=k;i++){
              if(curr+i>target){
                continue;
              }
              ans+=helper(ind+1,n,k,target,curr+i);
        }
        return dp[ind][curr]=ans % mod;
    }
}