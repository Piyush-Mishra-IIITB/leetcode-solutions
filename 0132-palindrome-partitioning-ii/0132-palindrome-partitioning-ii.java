class Solution {
    Integer dp[];
    public int minCut(String s) {
        dp=new Integer[s.length()+1];
        return helper(s,0,s.length()-1);
    }
    public int helper(String s,int i,int j){
        if(i>=j){
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        if(isbol(s,i,j)){
            return 0;
        }
        int ans=0;
        int output=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            if(isbol(s,i,k)){
                ans=1+helper(s,k+1,j);
            }
            output=Math.min(output,ans);
        }
        return dp[i]=output;
    }
    public boolean isbol(String s,int i,int j){

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}