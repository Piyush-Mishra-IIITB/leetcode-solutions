class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int newOne[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            newOne[i]=nums[i];
        }
        Arrays.sort(nums);
        int start=-1;
        int end=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=newOne[i]){
                start=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]!=newOne[i]){
               end=i;
               break;
            }
        }
        if(start==-1){
            return 0;
        }
        return end-start+1;
    }
}