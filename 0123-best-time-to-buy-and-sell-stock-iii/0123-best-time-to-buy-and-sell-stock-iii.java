class Solution {
    Integer dp[][][];
    public int maxProfit(int[] prices) {
        dp=new Integer[prices.length][2][3];
       return helper(0,0,0,prices);
    }
    public int helper(int ind,int buy,int times,int arr[]){
        if(ind==arr.length){
            return 0;
        }
        if(times==2){
            return 0;
        }
        if(dp[ind][buy][times]!=null){
            return dp[ind][buy][times];
        }
        int ans=0;
        if(buy==1){
            int sell=arr[ind]+helper(ind+1,0,times+1,arr);
            int skip=helper(ind+1,1,times,arr);
            ans=Math.max(sell,skip);
        }else{
            int b=-arr[ind]+helper(ind+1,1,times,arr);
            int s=helper(ind+1,0,times,arr);
            ans=Math.max(b,s);
        }
        return dp[ind][buy][times]=ans;
    }
}