class Solution {
    Integer dp[][];
    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int arr[]=new int[57];
        for(int i=0;i<=56;i++){
            arr[i]=i+2;
        }
        dp=new Integer[57][57];
        return helper(0,arr,n);
    }
    public int helper(int ind,int arr[],int target){
        if(ind==arr.length-1){
            if(arr[ind]<=target && arr[ind]%target==0){
                return target/arr[ind];
            }
            return 1;
        }
        if(dp[ind][target]!=null){
            return dp[ind][target];
        }
        int notpick=helper(ind+1,arr,target);
        int pick=1;
          if (arr[ind]<=target){
             pick=arr[ind]*helper(ind,arr,target-arr[ind]);
          }
          return dp[ind][target]=Math.max(pick,notpick);
    }
}