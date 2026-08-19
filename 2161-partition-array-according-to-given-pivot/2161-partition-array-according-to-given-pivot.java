class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int minNo=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                 minNo++;
            }
           
        }
        int maxNo=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>pivot){
               maxNo++;
            }
           
        }
        int ans[]=new int[nums.length];
        int low=0;
        int high=nums.length-maxNo;
        for(int i=0;i<nums.length;i++){
            ans[i]=pivot;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                ans[low]=nums[i];
                low++;
            }else if(nums[i]>pivot){
                ans[high]=nums[i];
                high++;
            }
        }
        return ans;

    }
}