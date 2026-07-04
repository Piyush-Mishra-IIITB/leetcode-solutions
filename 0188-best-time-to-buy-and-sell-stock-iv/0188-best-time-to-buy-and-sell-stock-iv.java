class Solution {
    int dp[][][];
    public int maxProfit(int k, int[] prices) {
         dp=new int[prices.length][2][k+1];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int z=0;z<=k;z++){
                    dp[i][j][z]=-1;
                }
            }
        }
        return helper(0,1,prices,k);
    }
    public int helper(int i,int buy,int arr[],int stop){
        if(stop==0){return 0;}
        if(i==arr.length){return 0;}
        if(dp[i][buy][stop]!=-1){
            return dp[i][buy][stop];
        }
        int price;
        if(buy==1){
            int b=-arr[i]+helper(i+1,0,arr,stop);
            int not=helper(i+1,1,arr,stop);
            price=Math.max(b,not);
        }else{
            int sell=arr[i]+helper(i+1,1,arr,stop-1);
            int hold=helper(i+1,0,arr,stop);
            price=Math.max(sell,hold);
        }
        return dp[i][buy][stop]=price;
    }
}
