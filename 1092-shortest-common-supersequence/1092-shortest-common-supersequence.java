class Solution {
    int dp[][];
    public String shortestCommonSupersequence(String s1, String s2) {
        dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                dp[i][j]=-1;
            }
        }
        helper(dp,0,0,s1,s2);
        StringBuilder sb=new StringBuilder();
        int n1=0;
        int n2=0;
        while(n1<s1.length() && n2<s2.length()){
            if(s1.charAt(n1)==s2.charAt(n2)){
                sb.append(s1.charAt(n1));
                n1++;
                n2++;
            }
            else if(dp[n1+1][n2]>dp[n1][n2+1]){
                sb.append(s1.charAt(n1));
                n1++;
            }else{
                sb.append(s2.charAt(n2));
                n2++;
            }
        }
        while(n1<s1.length()){
            sb.append(s1.charAt(n1));
                n1++;
        }
         while(n2<s2.length()){
            sb.append(s2.charAt(n2));
                n2++;
        }
        return sb.toString();
    }
    public int helper(int dp[][],int i,int j,String s1,String s2){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=1+helper(dp,i+1,j+1,s1,s2);
        }else{
           ans=0+Math.max(helper(dp,i,j+1,s1,s2),helper(dp,i+1,j,s1,s2));
        }
        return dp[i][j]=ans;
    }
}
