class Solution {
    Integer dp[][];
    public int numDistinct(String s, String t) {
        dp=new Integer[s.length()+1][t.length()+1];
       return helper(0,0,s,t);
    }
    public int helper(int i,int j,String s,String t){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans=0;
        ans+=helper(i+1,j,s,t);
        if(s.charAt(i)==t.charAt(j)){
            ans+=helper(i+1,j+1,s,t);
        }
        return dp[i][j]=ans;
    }
}