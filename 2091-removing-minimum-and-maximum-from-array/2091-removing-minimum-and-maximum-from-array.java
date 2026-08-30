class Solution {
    public int minimumDeletions(int[] nums) {
        int minIdx = -1;
        int maxIdx = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                max = nums[i];
                maxIdx = i;
            }
            if(nums[i]<min){
                min = nums[i];
                minIdx = i;
            }
        }
        int bothSideDel = Math.min(maxIdx, minIdx) + 1 + nums.length - Math.max(maxIdx, minIdx);
        int singleSideDel = Math.min(Math.max(maxIdx, minIdx) + 1, nums.length - Math.min(minIdx, maxIdx));
        return Math.min(bothSideDel, singleSideDel);
    }
}