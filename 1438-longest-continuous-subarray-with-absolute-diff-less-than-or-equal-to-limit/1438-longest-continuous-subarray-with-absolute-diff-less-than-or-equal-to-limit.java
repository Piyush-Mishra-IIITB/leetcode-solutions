class Solution {
    public int longestSubarray(int[] nums, int limit) {
       
       int i=0;
       int ans=0;
       TreeMap<Integer,Integer>hm=new TreeMap<>();
       for(int j=0;j<nums.length;j++){
          int curr=nums[j];
          if(hm.containsKey(curr)){
            hm.put(curr,hm.get(curr)+1);
          }else{
            hm.put(curr,1);
          }
          while(hm.lastKey()-hm.firstKey()>limit){
              int val=hm.get(nums[i]);
              hm.remove(nums[i]);
              if(val>1){
                hm.put(nums[i],val-1);
              }
             i++;
          }
        ans=Math.max(ans,j-i+1);
       }
      return ans;
    }
}