class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int output=0;
        for(int i=0;i<nums.length;i++){
            int find=nums[i]+k;
            int find2=nums[i]-k;
            if(hm.containsKey(find)){
                output=output+hm.get(find);
            }
            if(hm.containsKey(find2)){
                output=output+hm.get(find2);
            }
           if(hm.containsKey(nums[i])){
              hm.put(nums[i],hm.get(nums[i])+1);
           }else{
            hm.put(nums[i],1);
           }
        }
        return output;
    }
}