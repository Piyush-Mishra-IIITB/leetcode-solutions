class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max[]=new int[nums.length];
        max[0]=nums[0];
        int m=nums[0];
        for(int i=1;i<nums.length;i++){
             if(nums[i]>m){
                m=nums[i];
                max[i]=m;
             }else{
                max[i]=m;
             }
        }
        int min[]=new int[nums.length];
        min[nums.length-1]=nums[nums.length-1];
        int mi=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(mi>nums[i]){
               mi=nums[i];
               min[i]=mi;
            }else{
                min[i]=mi;
            }
        }
        int op=nums.length+1;
        for(int i=0;i<nums.length;i++){
            int m1=max[i];
            int m2=min[i];
            int val=m1-m2;
            if(k>=val){
                op=Math.min(op,i);
            }
        }
        return op==nums.length+1 ?-1 :op;
    }
}