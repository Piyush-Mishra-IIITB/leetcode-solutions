class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count=1;
        int ans=1;
        for(int i=1;i<nums.length;i++){
           if(nums[i]>nums[i-1]){
              count++;
              ans=Math.max(ans,count);
           }else{
            count=1;
           }
        }
        return ans;
    }
}