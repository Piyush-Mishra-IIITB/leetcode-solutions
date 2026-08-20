class Solution {
    public int[] applyOperations(int[] nums) {
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
               nums[i]=nums[i]*2;
               nums[i+1]=0;  
            }
        }
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        
        int i=0;
        int j=1;
        while(i<nums.length && j<nums.length){
              
              while(i<nums.length&& nums[i]!=0){
                    i++;
              }
              if(j<=i){
                    j=i+1;
              }
              
              while(j<nums.length && j>i && nums[j]==0){
                   j++;
              }
              if(j<nums.length && i<nums.length){
                  int t=nums[i];
                 nums[i]=nums[j];
                 nums[j]=t;
              }
              
        }
      return nums;
    }
}