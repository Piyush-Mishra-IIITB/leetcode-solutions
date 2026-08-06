class Solution {
    Integer dp[][];
    int offset;
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int i=0;i<stones.length;i++){
            sum+=stones[i];
        }
        offset=sum;
        dp=new Integer[stones.length][2*sum+1];
        return helper(0,stones,0);
    }
    public int helper(int ind,int arr[],int currSum){
        if(ind==arr.length){
            if(currSum>=0){
                return currSum;
            }
            return Integer.MAX_VALUE;
        }
        if(dp[ind][currSum+offset]!=null){
            return dp[ind][currSum+offset];
        }
        int a=helper(ind+1,arr,currSum+arr[ind]);
        int b=helper(ind+1,arr,currSum-arr[ind]);
        return dp[ind][currSum+offset]=Math.min(a,b);
    }
}