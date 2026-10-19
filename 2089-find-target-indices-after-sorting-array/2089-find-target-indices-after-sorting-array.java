class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer>ll=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            if(curr==target){
                ll.add(i);
            }
        }
        return ll;
    }
}