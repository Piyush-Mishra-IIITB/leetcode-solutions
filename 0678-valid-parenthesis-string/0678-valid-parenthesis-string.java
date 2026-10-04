class Solution {
    Boolean dp[][];
    public boolean checkValidString(String s) {
        dp=new Boolean[s.length()+1][s.length()+1];
        return helper(0,0,s);
    }
    public boolean helper(int i,int count,String s){
        if(count<0){
            return false;
        }
        if(i>=s.length()&& count!=0){
            return false;
        }
        if(i>=s.length() && count==0){
            return true;
        }
        if(dp[i][count]!=null){
            return dp[i][count];
        }
        if(s.charAt(i)=='('){
            int nc=count+1;
            return dp[i][count]=helper(i+1,nc,s);
        }else if(s.charAt(i)==')'){
            int nc=count-1;
            return dp[i][count]=helper(i+1,nc,s);
        }else{
            int np=count+1;
            int nd=count-1;
            int sm=count;
            return dp[i][count]=helper(i+1,np,s) || helper(i+1,nd,s) || helper(i+1,sm,s);
        }
    }
}