class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>hm=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hm.add(nums[i]);
        }
         int ans=0;
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            if(hm.contains(curr-1)){
                continue;
            }
            if(!hm.contains(curr)){
                continue;
            }
            
            int length=1;
            while(hm.contains(curr+1)){
                hm.remove(curr);
                curr=curr+1;
               length++;
            }
            ans=Math.max(ans,length);
        }
        return ans;
    }
}