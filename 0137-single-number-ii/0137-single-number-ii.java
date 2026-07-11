class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            if(hm.containsKey(curr)){
               hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
        }
        for(Integer it:hm.keySet()){
            if(hm.get(it)==1){
                return it;
            }
        }
        return -1;
    }
}