class Solution {
    public int missingInteger(int[] nums) {
        int val=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-1==val){
                val=nums[i];
                sum+=nums[i];
            }else{
              break;
            }
        }
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        while(true){
            if(!hs.contains(sum)){
                return sum;
            }
            sum++;
        }
    }
}