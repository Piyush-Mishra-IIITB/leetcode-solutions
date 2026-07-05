class Solution {
    Integer dp[][];
    public int minCost(int n, int[] cuts) {
        int arr[]=new int[cuts.length+2];
        arr[0]=0;
        arr[arr.length-1]=n;
        Arrays.sort(cuts);
        dp=new Integer[cuts.length+1][cuts.length+1];
        for(int i=1;i<arr.length-1;i++){
             arr[i]=cuts[i-1];
        }
        return helper(1,cuts.length,arr);
    }
    public int helper(int i,int j,int arr[]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
             int cost=arr[j+1]-arr[i-1]+helper(i,k-1,arr)+helper(k+1,j,arr);
             min=Math.min(min,cost);
        }
        return dp[i][j]=min;
    }
}