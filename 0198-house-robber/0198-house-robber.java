class Solution {
    int dp[];
    public int rob(int[] arr) {
        if(arr.length==0){
            return 0;
        }
        dp=new int[arr.length+1];
        Arrays.fill(dp,-1);
        return helper(arr,0);
    }
    public int helper(int arr[],int index){
        if(index>=arr.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int pick=arr[index]+helper(arr,index+2);
        int notPick=0+helper(arr,index+1);
        return dp[index]=Math.max(pick,notPick);
    }

    }  