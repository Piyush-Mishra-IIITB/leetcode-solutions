class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
       List<Integer>index=new ArrayList<>();
       for(int i=0;i<nums.length;i++){
           if(nums[i]==key){
            index.add(i);
           }
       }
       int length=nums.length;
       List<Integer>ans=new ArrayList<>();
       HashSet<Integer>hs=new HashSet<>();
       for(Integer it:index){
            for(int i=Math.max(0,it-k);i<=Math.min(it+k,length-1);i++){
                hs.add(i);
            }
       }
       for(Integer it:hs){
        ans.add(it);
       }
       Collections.sort(ans);
       return ans;
    }
}