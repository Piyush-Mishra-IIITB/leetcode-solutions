class Solution {
    Integer dp[][][];
    public int countDigitOne(int n) {
        StringBuilder sb=new StringBuilder();
        int x=n;
        while(x>0){
            sb.append(x%10);
            x=x/10;
        }
       dp=new Integer[11][2][11];
    return helper(0,1,sb.reverse().toString(),0);
       
    }
    public int helper(int ind,int tide,String s,int val){
      if(s.length()==ind){
         return val;
      }
      if(dp[ind][tide][val]!=null){
         return dp[ind][tide][val];
      }
      int ans=0;
      int lw=0;
      int up=9;
      if(tide==1){
        up=s.charAt(ind)-'0';
      }
      for(int i=lw;i<=up;i++){
        int newTight=tide;
         if(tide==1 && i==s.charAt(ind)-'0'){
            newTight=1;
         }else{
            newTight=0;
         }
         if(i==1){
            ans+=helper(ind+1,newTight,s,val+1);
         }else{
            ans+=helper(ind+1,newTight,s,val);
         }
         
      }
      return dp[ind][tide][val]=ans;
    }
}