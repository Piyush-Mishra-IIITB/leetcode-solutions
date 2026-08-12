class Solution {
    Integer dp[][][];
    public int wiggleMaxLength(int[] arr) {
        dp=new Integer[arr.length][arr.length+1][3];
        return helper(0,-1,-1,arr);
    }
    public int helper(int ind,int prev,int state,int arr[]){
        if(ind>=arr.length){
            return 0;
        }
        if(dp[ind][prev+1][state+1]!=null){
            return dp[ind][prev+1][state+1];
        }
        int ans=0;
        if(prev==-1){
            int a=1+helper(ind+1,ind,-1,arr);
            int b=helper(ind+1,prev,-1,arr);
            ans=Math.max(ans,Math.max(a,b));
        }
        else if(state ==-1){
            if(arr[ind]-arr[prev]>0){
                ans=Math.max(1+helper(ind+1,ind,1,arr),helper(ind+1,prev,-1,arr));
            }
            else if(arr[ind]-arr[prev]<0){
                ans=Math.max(1+helper(ind+1,ind,0,arr),helper(ind+1,prev,-1,arr));
            }
            else{
                ans=helper(ind+1,prev,-1,arr);
            }
            
        }
        else if(state==1){
            if(arr[ind]<arr[prev]){
                ans=Math.max(helper(ind+1,prev,1,arr),1+helper(ind+1,ind,0,arr));
            }else{
                ans=helper(ind+1,prev,1,arr);
            }
        }
        else{
            if(arr[ind]>arr[prev]){
                ans=Math.max(helper(ind+1,prev,0,arr),1+helper(ind+1,ind,1,arr));
            }else{
                ans=helper(ind+1,prev,0,arr);
            }
        }
        return dp[ind][prev+1][state+1]=ans;
    }
}