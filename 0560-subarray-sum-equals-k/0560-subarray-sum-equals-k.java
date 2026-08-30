class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,1);
        int ans=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int find=sum-k;
            if(hm.containsKey(find)){
                ans+=hm.get(find);
            }
            if(hm.containsKey(sum)){
                hm.put(sum,hm.get(sum)+1);
            }else{
                hm.put(sum,1);
            }
        }
        return ans;
    }
}