class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        
        if(nums.length==1){
            return true;
        }
        int mid=nums.length/2;
        int val=nums[mid];
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                count++;
            }
        }
        return count==1;
    }
}