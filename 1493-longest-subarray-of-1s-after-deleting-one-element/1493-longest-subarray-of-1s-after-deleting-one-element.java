class Solution {
    public int longestSubarray(int[] arr) {
        int low=0;
        int sum=0;
        int ans=0;
        for(int high=0;high<arr.length;high++){
              sum+=arr[high];
              while(high-low>sum){
                sum-=arr[low];
                low++;
              }
           ans=Math.max(ans,high-low);
        }
        return ans;
    }
}