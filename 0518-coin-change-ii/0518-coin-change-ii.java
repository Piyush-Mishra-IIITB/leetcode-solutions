class Solution {
    Integer dp[][];
    public int change(int amount, int[] coins) {
        dp=new Integer[coins.length][amount+1];
        return helper(0,amount,coins);
    }
    public int helper(int ind,int target,int arr[]){
        if(target==0){
            return 1;
        }
        if(ind==arr.length){
            return 0;
        }
        if(dp[ind][target]!=null){
            return dp[ind][target];
        }
        int nottake=helper(ind+1,target,arr);
        int take=0;
         if(arr[ind]<=target){
            take=helper(ind,target-arr[ind],arr);
         }

         return dp[ind][target]=nottake+take;
    }
}