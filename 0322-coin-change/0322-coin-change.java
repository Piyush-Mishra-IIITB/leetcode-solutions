class Solution {
    Integer dp[][];
    public int coinChange(int[] coins, int amount) {
        dp=new Integer[coins.length][amount+1];
       if(amount==0){
        return 0;
       }
       return helper(0,coins,amount)==Integer.MAX_VALUE ? -1:helper(0,coins,amount);
}
  public int helper(int i,int arr[],int target){
    if(i==arr.length-1){
        if(target%arr[i]==0){
            return target / arr[i];
        }else{
            return Integer.MAX_VALUE;
        }
    }
    if(target==0){
        return 0;
    }
    if(target<0){
        return Integer.MAX_VALUE;
    }
    if(dp[i][target]!=null){
        return dp[i][target];
    }
     int notTake=0+helper(i+1,arr,target);
     int take=Integer.MAX_VALUE;
     if(arr[i]<=target){
        take=helper(i,arr,target-arr[i]);
        if(take!=Integer.MAX_VALUE){
            take=take+1;
        }
     }
     return dp[i][target]=Math.min(take,notTake);
  }
}