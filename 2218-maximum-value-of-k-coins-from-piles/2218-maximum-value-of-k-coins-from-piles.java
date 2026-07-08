class Solution {
    Integer dp[][];
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp=new Integer[piles.size()+1][k+1];
        return helper(piles,k,0);
    }
    public int helper(List<List<Integer>>aa,int k,int ind){
        if(ind==aa.size()){
          return 0;
        }
        if(k==0){
            return 0;
        }
        if(dp[ind][k]!=null){
            return dp[ind][k];
        }
        int skip=helper(aa,k,ind+1);
        int pick=0;
        int sum=0;
        for(int i=0;i<Math.min(aa.get(ind).size(),k);i++){
            sum+=aa.get(ind).get(i);
            pick=Math.max(pick,sum+helper(aa,k-(i+1),ind+1));
        }
        return dp[ind][k]=Math.max(pick,skip);
    }
}