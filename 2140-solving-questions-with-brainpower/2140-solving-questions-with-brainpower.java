class Solution {
    Long dp[];
    public long mostPoints(int[][] questions) {
        dp=new Long[questions.length+1];
        return helper(0,questions);
    }
    public long helper(int ind,int arr[][]){
        if(ind>=arr.length){
            return 0;
        }
        if(dp[ind]!=null){
            return dp[ind];
        }
        long skip=0+helper(ind+1,arr);
        long pick=arr[ind][0]+helper(ind+arr[ind][1]+1,arr);
        return dp[ind]=Math.max(skip,pick);
    }
}