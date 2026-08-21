class Solution {
    public int[] finalPrices(int[] nums) {
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            boolean find=false;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>=nums[j]){
                    find=true;
                  ans[i]=nums[i]-nums[j];
                  break;
                }
            }
            if(!find){
                ans[i]=nums[i];
            }
        }
        return ans;

    }
}