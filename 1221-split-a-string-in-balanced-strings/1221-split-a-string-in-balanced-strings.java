class Solution {
    Integer dp[][];
    public int balancedStringSplit(String s) {
        dp=new Integer[s.length()+1][s.length()+1];
        return count(0,s.length()-1,s);
    }
    public int count(int i,int j,String s){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans=0;
        int co=0;
        for(int k=i;k<=j;k++){
            if(helper(s,i,k)){
                co=1+count(k+1,j,s);
                ans=Math.max(ans,co);
            }
        }
        return dp[i][j]=ans;
    }
    public boolean helper(String s,int i,int j){
        int r=0;
        int l=0;
        for(int k=i;k<=j;k++){
            char curr=s.charAt(k);
            if(curr=='R'){
                r++;
            }else{
                l++;
            }
        }
        return l==r;
    }
}