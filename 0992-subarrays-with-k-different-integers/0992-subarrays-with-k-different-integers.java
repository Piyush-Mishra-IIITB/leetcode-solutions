class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(k,nums)-helper(k-1,nums);
    }
    public int helper(int k,int nums[]){
        HashMap<Integer,Integer>hm=new HashMap<>();
        int i=0;
        int count=0;
        for(int j=0;j<nums.length;j++){
            int curr=nums[j];
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
            while(hm.size()>k){
                int val=hm.get(nums[i]);
                hm.remove(nums[i]);
                if(val>1){
                    hm.put(nums[i],val-1);
                }
                i++;
            }
            count+=j-i+1;
        }
        return count;
    }
}