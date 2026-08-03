class Solution {
    Integer dp[];
    public String stoneGameIII(int[] st) {
        dp=new Integer[st.length];
       int ans=helper(0,st);
       if(ans>0){
        return "Alice";
       }
       else if(ans==0){
        return "Tie";
       }else{
        return "Bob";
       }
    }
    public int helper(int ind,int arr[]){
         if(ind==arr.length){
            return 0;
         }
         if(dp[ind]!=null){
            return dp[ind];
         }
         int ans=Integer.MIN_VALUE;
         int a=arr[ind]-helper(ind+1,arr);
         int b=Integer.MIN_VALUE;
         if(ind+1<arr.length){
            b=arr[ind]+arr[ind+1]-helper(ind+2,arr);
         }
         int c=Integer.MIN_VALUE;
         if(ind+2<arr.length){
            c=arr[ind]+arr[ind+1]+arr[ind+2]-helper(ind+3,arr);
         }
         int d=Math.max(a,b);
         int e=Math.max(c,d);
         ans=Math.max(ans,e);
         return dp[ind]=ans;
}}