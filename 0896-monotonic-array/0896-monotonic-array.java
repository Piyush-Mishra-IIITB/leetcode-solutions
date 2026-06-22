class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int first=nums[0];
        int second=nums[1];
        boolean incr=false;
        boolean decr=true;
        if(first<second){
            incr=true;
            decr=false;
        }
        if(first==second){
            for(int i=2;i<nums.length;i++){
                if(nums[0]<nums[i]){
                    incr=true;
                    break;
                }
            }
        }
        for(int i=1;i<nums.length-1;i++){
              if(incr){
                   if(nums[i]>nums[i+1]){
                    return false;
                   }
              }
              else if(decr){
                   if(nums[i]<nums[i+1]){
                    return false;
                   }
              }
        }
        return true;
    }
}