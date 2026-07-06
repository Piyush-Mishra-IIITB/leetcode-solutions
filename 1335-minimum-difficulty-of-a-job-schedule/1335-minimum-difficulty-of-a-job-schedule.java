class Solution {
    Integer dp[][];
    public int minDifficulty(int[] arr, int d) {
        if(arr.length<d){
            return -1;
        }
        dp=new Integer[arr.length+1][d+1];
        return helper(0,arr.length-1,d-1,arr);
    }
    public int helper(int i,int j,int d,int arr[]){
        if(i>=arr.length){
            return 0;
        }
        if(d==0){
            return helper3(arr,i);
        }
        if(dp[i][d]!=null){
            return dp[i][d];
        }
        int min=Integer.MAX_VALUE;
        for(int ind=i;ind<arr.length;ind++){
            if(j-ind>=d){
                int cost=helper2(arr,ind,i)+helper(ind+1,j,d-1,arr);
                 min=Math.min(cost,min);
            }
        }
        return dp[i][d]=min;
    }
    public int helper2(int arr[],int ind,int j){
        int max=0;
        for(int i=j;i<=ind;i++){
            max=Math.max(arr[i],max);
        }
        return max;
    }
    public int helper3(int arr[],int ind){
        int max=0;
        for(int i=ind;i<arr.length;i++){
            max=Math.max(arr[i],max);
        }
        return max;
    }
}