class Solution {
    public int subarraySum(int[] nums, int k) {
      HashMap<Integer,Integer>hm=new HashMap<>();
      hm.put(0,1);
      int prefix=0;
      int ans=0;
      for(int x:nums){
         prefix+=x;
         int find=prefix-k;
         if(hm.containsKey(find)){
            ans+=hm.get(find);
         }
         if(hm.containsKey(prefix)){
            hm.put(prefix,hm.get(prefix)+1);
         }else{
            hm.put(prefix,1);
         }
      }
      return ans;
    }
}
