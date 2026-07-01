class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,-1);
        int sum=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hm.containsKey(sum%k)){
                if(i-hm.get(sum%k)>=2){
                   return true;
                }
            }
            else{
                hm.put(sum%k,i);
            }
        }
        return false;
    }
}