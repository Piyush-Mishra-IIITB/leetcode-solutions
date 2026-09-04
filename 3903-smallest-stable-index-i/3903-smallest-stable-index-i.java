class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int op=nums.length+1;

        for(int i=0;i<nums.length;i++){
           
           int max=nums[i];
           for(int j=0;j<=i;j++){
            max=Math.max(nums[j],max);
           }
           int min=nums[i];
           for(int j=i;j<nums.length;j++){
            min=Math.min(nums[j],min);
           }
           if(k>=max-min){
              op=Math.min(op,i);
           }
        }
        return op==nums.length+1 ? -1: op;
    }
}