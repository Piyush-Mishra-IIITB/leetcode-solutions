class Solution {
    Integer dp[][];
    public int minDistance(String word1, String word2) {
        if(word1.length()==0 && word2.length()==0){
            return 0;
        }
        dp=new Integer[word1.length()][word2.length()];
        return helper(0,0,word1,word2);
    }
    public int helper(int i,int j,String s,String t){
        if(j==t.length()){
            return s.length()-i;
        }
        if(i==s.length()&& j!=t.length()){
            return t.length()-j;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            ans+=helper(i+1,j+1,s,t);
        }else{
            int replace=helper(i+1,j+1,s,t);
            int delete=helper(i+1,j,s,t);
            int insert=helper(i,j+1,s,t);
            int op=Math.min(Math.min(replace,delete),insert);
            if(op!=Integer.MAX_VALUE){
                ans+=1+op;
            }
        }
        return dp[i][j]= ans;
    }
}