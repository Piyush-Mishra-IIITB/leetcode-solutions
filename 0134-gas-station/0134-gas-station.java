class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==1){
            if(gas[0]==cost[0]){
                return 0;
            }
        }
       int n=gas.length;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){

                if(gas[i]>cost[i]){
                    if(helper(i,gas,cost,n)){
                        return i;
                    }
                }
        }
        return -1;
    }
    public boolean helper(int i,int gas[],int cost[],int n){
           int g=0;
           g=g+gas[i];
           int j=i;
           for(j=i+1;j<2*n;j++){
                g-=cost[(j-1)%n];
                if(g<0){
                    return false;
                }
                g+=gas[j%n];
           }
           return true;
    }
}