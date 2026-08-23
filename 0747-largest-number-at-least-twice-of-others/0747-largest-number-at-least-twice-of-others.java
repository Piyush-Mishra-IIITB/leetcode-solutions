class Solution {
    public int dominantIndex(int[] nums) {
        int max=nums[0];
        int ind=0;
        int secondmax=-1;
        for(int i=1;i<nums.length;i++){
            if(max<nums[i]){
                secondmax=max;
                max=nums[i];
                ind=i;
            }
            else if(secondmax<nums[i]){
                secondmax=nums[i];
            }
        }

        if(max>=2*secondmax){
            return ind;
        }
        return -1;
    }
}