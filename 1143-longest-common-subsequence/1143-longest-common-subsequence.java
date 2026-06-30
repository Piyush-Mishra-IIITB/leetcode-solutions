class Solution {
    Integer dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        dp=new Integer[text1.length()][text2.length()];
        return helper(text1,text2,0,0);
    }
    public int helper(String ss1,String ss2,int i,int j){
        if(i==ss1.length() || j==ss2.length()){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans=0;
        if(ss1.charAt(i)==ss2.charAt(j)){
            ans=1+helper(ss1,ss2,i+1,j+1);
        }else{
            ans=0+Math.max(helper(ss1,ss2,i,j+1),helper(ss1,ss2,i+1,j));
        }
        return dp[i][j]=ans;
    }
}