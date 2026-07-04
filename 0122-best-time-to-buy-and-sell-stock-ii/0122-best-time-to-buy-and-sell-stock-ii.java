class Solution {
    Integer dp[][];
    public int maxProfit(int[] prices) {
        dp=new Integer[prices.length+1][3];
       return helper(0,0,prices);
    }
    public int helper(int i,int b,int arr[]){
        if(i==arr.length){
            return 0;
        }
        if(dp[i][b]!=null){
            return dp[i][b];
        }
        int ans=0;
        if(b==1){
            int sell=arr[i]+helper(i+1,0,arr);
            int buy_sell=helper(i+1,1,arr);
            ans=Math.max(sell,buy_sell);
        }else{
            int buy=-arr[i]+helper(i+1,1,arr);
            int not=helper(i+1,0,arr);
            ans=Math.max(buy,not);
        }
        return dp[i][b]=ans;

    }
}
