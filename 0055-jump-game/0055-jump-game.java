class Solution {
    Boolean dp[];
    public boolean canJump(int[] arr) {
        dp=new Boolean[arr.length+1];
        return helper(arr,0);
    }
    public boolean helper(int arr[],int ind){
        if(ind==arr.length-1){
            return true;
        }
        if(ind>=arr.length){
            return false;
        }
        if(arr[ind]==0){
            return false;
        }
        if(dp[ind]!=null){
            return dp[ind];
        }
        for(int i=1;i<=arr[ind];i++){
            if(helper(arr,ind+i)){
               return dp[ind]=true;
            }
        }
        return dp[ind]=false;
    }
}
