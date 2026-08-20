class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            int find=target-curr;
            if(hm.containsKey(find)){
                ans[0]=i;
                ans[1]=hm.get(find);
                return ans;
            }
            hm.put(curr,i);
        }
        return ans;
    }
}