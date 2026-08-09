class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        int sum2=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i];
        }
        for(int i=0;i<cost.length;i++){
            sum2+=cost[i];
        }
        
        if(sum<sum2){
            return -1;
        }
        for(int i=0;i<cost.length;i++){
            if(gas[i]>=cost[i]){
                int a=helper(i,gas,cost);
            if(a==i){
                return i;
            }else{
                i=a-1;
            }
            }
        }
        return -1;
    }
    public int helper(int ind,int gas[],int cost[]){
        
        int length=gas.length;
        int c=gas[ind%length]-cost[ind%length];
        for(int i=ind+1;i<2*gas.length;i++){
            if(c<0){
                return i%length;
            }
            if(i%length==ind){
                return ind;
            }
            c+=gas[i%length]-cost[i%length];
        }
        return -1;
    }
}