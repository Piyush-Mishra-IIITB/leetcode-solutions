class Solution {
    Integer dp[][];
    public int stoneGameII(int[] arr) {
        dp=new Integer[arr.length][arr.length+1];
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int mid=sum/2;
        int val=helper(0,arr,1);
        return (sum + val) / 2;
    }
    public int helper(int ind,int arr[],int m){
       if(ind==arr.length){
        return 0;
       }
       if(dp[ind][m]!=null){
        return dp[ind][m];
       }
       int ans=Integer.MIN_VALUE;
       int sum=0;
       for(int i=ind;i<=Math.min(arr.length-1,ind+2*m-1);i++){
           sum+=arr[i];
           int curr=sum-helper(i+1,arr,Math.max(m,i-ind+1));
           ans=Math.max(ans,curr);
       }
       return dp[ind][m]=ans;
    }
}