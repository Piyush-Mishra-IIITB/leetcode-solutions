class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long maxp=total/cost1;
        long ans=0;
        for(long i=0;i<=maxp;i++){
             ans+=helper(total-cost1*i,cost2);
        }
        return ans;
    }
     public long helper(long cost,long n){
         long maxp=cost/n;
        return maxp+1;
     }
}