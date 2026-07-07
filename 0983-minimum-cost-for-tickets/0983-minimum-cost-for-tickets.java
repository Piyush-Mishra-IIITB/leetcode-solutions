class Solution {
    Integer dp[];
    public int mincostTickets(int[] days, int[] costs) {
        dp=new Integer[400];
        return helper(0,days,costs);
    }
    public int helper(int ind,int arr[],int cost[]){
        if(ind>=arr.length){
            return 0;
        }
        if(dp[ind]!=null){
            return dp[ind];
        }
        int next1=BinaryS(arr,ind,1);
        int next7=BinaryS(arr,ind,7);
        int next30=BinaryS(arr,ind,30);
        int oneDay=cost[0]+helper(next1,arr,cost);
        int sevenDay=cost[1]+helper(next7,arr,cost);
        int thirtyDay=cost[2]+helper(next30,arr,cost);
        return dp[ind]=Math.min(Math.min(oneDay,sevenDay),thirtyDay);
    }
    public int BinaryS(int arr[],int ind,int target){
        int start=ind;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>=arr[ind]+target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}