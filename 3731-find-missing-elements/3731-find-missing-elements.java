class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       Arrays.sort(nums);
       int small=nums[0];
       int large=nums[nums.length-1];
       HashSet<Integer>hs=new HashSet<>();
       for(int i=0;i<nums.length;i++){
        int curr=nums[i];
         hs.add(curr);
       }
       List<Integer>ans=new ArrayList<>();
       for(int i=small;i<=large;i++){
         if(!hs.contains(i)){
            ans.add(i);
         }
       }
       return ans;
    }
}