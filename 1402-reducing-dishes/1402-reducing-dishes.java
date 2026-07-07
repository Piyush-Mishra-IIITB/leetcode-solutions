class Solution {
    Integer dp[][];
    public int maxSatisfaction(int[] arr) {
        dp=new Integer[arr.length][2001];
        Arrays.sort(arr);
        return helper(0,arr,1);
    }
    public int helper(int ind,int arr[],int time){
        if(ind>=arr.length){
            return 0;
        }
        if(dp[ind][time]!=null){
            return dp[ind][time];
        }
        int skip=helper(ind+1,arr,time);
        int take=arr[ind]*time+helper(ind+1,arr,time+1);
        return dp[ind][time]=Math.max(skip,take);
    }
}