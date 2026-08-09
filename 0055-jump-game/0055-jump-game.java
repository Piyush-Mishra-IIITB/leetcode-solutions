class Solution {
    Boolean dp[];
    public boolean canJump(int[] arr) {
        if(arr.length==1){
            return true;
        }
        dp=new Boolean[arr.length+1];
        return helper(arr,0);
    }
    public boolean helper(int arr[],int ind){
       if(ind==arr.length-1){
        return true;
       }
       if(dp[ind]!=null){
        return dp[ind];
       }
       int currStep=arr[ind];
       if(currStep==0){
        return dp[ind]=false;
       }
       for(int i=1;i<=currStep;i++){
         if(helper(arr,ind+i)){
            return dp[ind]=true;
         }
       }
       return dp[ind]=false;
    }
}
