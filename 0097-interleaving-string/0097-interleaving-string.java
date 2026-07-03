class Solution {
    Boolean dp[][][];
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        dp=new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        boolean ans=helper(0,0,s1,s2,0,s3);
        return ans; 
    }
    public boolean helper(int i,int j,String s,String t,int k,String fin){
        if(i==s.length() && j==t.length()){
               if(k==fin.length()){
                return true;
               }
          return false;
        }

        if(dp[i][j][k]!=null){
            return dp[i][j][k];
        }
        boolean left=false;
       if(i<s.length() &&fin.charAt(k)==s.charAt(i)){
           left=helper(i+1,j,s,t,k+1,fin);
       }
       
       boolean right=false;
       if(j<t.length() && fin.charAt(k)==t.charAt(j)){
         right=helper(i,j+1,s,t,k+1,fin);
       }
        return dp[i][j][k]=left|| right;
    }
}