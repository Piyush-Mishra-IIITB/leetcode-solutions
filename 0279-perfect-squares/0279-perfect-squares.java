class Solution {
    Integer dp[][];
    public int numSquares(int n) {
        List<Integer>ll=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            ll.add(i*i);
        }
        int arr[]=new int[ll.size()];
        for(int i=0;i<ll.size();i++){
            arr[i]=ll.get(i);
        }
         for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        dp=new Integer[arr.length][10001];
       return helper(0,arr,n);
    }
    public int helper(int ind,int arr[],int target){
       if(ind==arr.length){
          if(target==0){
            return 0;
          }
          return Integer.MAX_VALUE;
       }
       if(dp[ind][target]!=null){
          return dp[ind][target];
       }
        int notpick=helper(ind+1,arr,target);
        int pick=Integer.MAX_VALUE;
        if(arr[ind]<=target){
            pick=helper(ind,arr,target-arr[ind]);
            if(pick!=Integer.MAX_VALUE){
                pick++;
            }
        }
        return dp[ind][target]=Math.min(pick,notpick);
    }
}