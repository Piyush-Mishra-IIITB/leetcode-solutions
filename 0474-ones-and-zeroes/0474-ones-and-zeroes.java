class Solution {
    Integer dp[][][];
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new Integer[strs.length][m+1][n+1];
        return helper(0,m,n,strs);
    }
    public int helper(int ind,int m,int n,String strs[]){

      if(ind>=strs.length){
        return 0;
      }
      if(dp[ind][m][n]!=null){
        return dp[ind][m][n];
      }
        int notpick=helper(ind+1,m,n,strs);
        int pick=0;
           String curr=strs[ind];
           int zeros=0;
           int ones=0;
           for(int i=0;i<curr.length();i++){
                char c=curr.charAt(i);
                if(c=='0'){
                    zeros++;
                }else{
                    ones++;
                }
           }
           if(zeros<=m && ones<=n){
            pick=1+helper(ind+1,m-zeros,n-ones,strs);
           }
           return dp[ind][m][n]=Math.max(pick,notpick);
    }
}