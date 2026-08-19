class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,1);
        int sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            sum+=nums[i];
            int find=sum%k;
            if(find<0){
                find=(find+k)%k;
            }
            if(hm.containsKey(find)){
               count+=hm.get(find);
            }
            
            if(hm.containsKey(find)){
                hm.put(find,hm.get(find)+1);
            }else{
                hm.put(find,1);
            }
        }
        return count;
    }
}