class Solution {
    int dp1[];
    int dp2[];
    public int rob(int[] arr) {
        if(arr.length==0){
            return 0;
        }
        if(arr.length==1){
            return arr[0];
        }
       dp1=new int[arr.length+1];
       dp2=new int[arr.length+1];
       int n=arr.length;
       Arrays.fill(dp1,-1);
       Arrays.fill(dp2,-1);
       int a=helper(0,n-2,arr);
       int b=helper2(1,n-1,arr);
       return Math.max(a,b);
    }
    public int helper(int i,int n,int arr[]){
        if(i>n){
            return 0;
        }
        if(dp1[i]!=-1){
            return dp1[i];
        }
        int pick=arr[i]+helper(i+2,n,arr);
        int notPick=0+helper(i+1,n,arr);
        return dp1[i]=Math.max(pick,notPick);
    }
    public int helper2(int i,int n,int arr[]){
        if(i>n){
            return 0;
        }
        if(dp2[i]!=-1){
            return dp2[i];
        }
        int pick=arr[i]+helper2(i+2,n,arr);
        int notPick=0+helper2(i+1,n,arr);
        return dp2[i]=Math.max(pick,notPick);
    }
}
