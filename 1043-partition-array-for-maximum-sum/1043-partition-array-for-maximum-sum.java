class Solution {
    Integer dp[];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new Integer[arr.length+1];
        return helper(0,arr,k);
    }
    public int helper(int i,int arr[],int k){
        if(i==arr.length){
           return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int max=Integer.MIN_VALUE;
        for(int ind=i;ind<arr.length;ind++){
            if(ind-i+1<=k){
                int cost=help(arr,i,ind)*(ind-i+1)+helper(ind+1,arr,k);
                max=Math.max(max,cost);
            }
        }
        return dp[i]=max;
    }
    public int help(int arr[],int i,int ind){
        int max=arr[i];
        for(int j=i;j<=ind;j++){
            max=Math.max(max,arr[j]);
        }
        return max;
    }
}