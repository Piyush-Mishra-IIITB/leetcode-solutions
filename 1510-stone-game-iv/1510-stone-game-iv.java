class Solution {
    Boolean dp[][];
    public boolean winnerSquareGame(int n) {
        dp=new Boolean[n+1][2];
        List<Integer>ll=new ArrayList<>();
        System.out.println((int)Math.sqrt(n));
        for(int i=1;i<=(int)Math.sqrt(n);i++){
            ll.add(i*i);
        }
        return helper(ll,n,1);
    }
    public boolean helper(List<Integer>ll,int n,int ch){
        if(n==0){
            if(ch==1){
                return false;
            }
            return true;
        }
        if(dp[n][ch]!=null){
            return dp[n][ch];
        }
        if(ch==1){
            for(int i=0;i<ll.size();i++){
                if(n>=ll.get(i)){
                    if(helper(ll,n-ll.get(i),0)){
                        return dp[n][ch]=true;
                    }
                }
            }
        }else{
            for(int i=0;i<ll.size();i++){
                if(n>=ll.get(i)){
                    if(!helper(ll,n-ll.get(i),1)){
                        return dp[n][ch]=false;
                    }
                }
            }
        }
        if(ch==1){
                return dp[n][ch]=false;
            }
            return dp[n][ch]=true; 
    }
}