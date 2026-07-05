class Solution {
    Integer dp[][];
    public int maxCoins(int[] nums) {
        int arr[]=new int[nums.length+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        dp=new Integer[nums.length+2][nums.length+2];
        for(int i=1;i<arr.length-1;i++){
            arr[i]=nums[i-1];
        }
        return helper(1,nums.length,arr);
    }
    public int helper(int i,int j,int arr[]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int max=0;
        for(int ind=i;ind<=j;ind++){
            int cost=arr[i-1] * arr[ind] * arr[j+1]+helper(i,ind-1,arr)+helper(ind+1,j,arr);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
}