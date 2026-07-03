class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        dp=new Boolean[s.length()][p.length()];
        return helper(0,0,s,p);
    }
    public boolean helper(int i,int j,String s,String t){
       if(j==t.length()){
          return i==s.length();
       }
       if(i==s.length()){
         while(j<t.length()){
             char q=t.charAt(j);
             if(q!='*'){
                return false;
             }
             j++;
         }
         return true;
       }
      if(dp[i][j]!=null){
        return dp[i][j];
      }
      boolean value=false;
      if(s.charAt(i)==t.charAt(j)){
          if(helper(i+1,j+1,s,t)){
           value=true;
          }
      }else{
        char d=t.charAt(j);
        if(d!='?' && d!='*'){
            value=false;
        }
        if(d=='?'){
            if(helper(i+1,j+1,s,t)){
               value=true;
             }
        }
        if(d=='*'){
            if(helper(i+1,j,s,t) || helper(i,j+1,s,t)){
                value=true;
            }
        }

      }
      return dp[i][j]=value;

    }
}