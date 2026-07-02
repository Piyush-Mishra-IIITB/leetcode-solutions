class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        HashMap<Integer,Long>hm=new HashMap<>();
        hm.put(k-1,0L);
        long prefix=0;
        long ans=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i];
            int rem=i%k;
            if(hm.containsKey(rem)){
                ans=Math.max(ans,prefix-hm.get(rem));
            }
            if(hm.containsKey(rem)==false){
                hm.put(rem,prefix);
            }
            if(hm.containsKey(rem)){
                if(hm.get(rem)>prefix){
                    hm.remove(rem);
                    hm.put(rem,prefix);
                }
            }
            
        }
        return ans;
    }
}