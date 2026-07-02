class Solution {
    public int[] twoSum(int[] nums, int target) {
       int op[]=new int[2];
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            int find=target-val;
            if(hm.containsKey(find)){
               op[0]=hm.get(find);
               op[1]=i;
               return op;
            }
            hm.put(val,i);
        }
        return op;
    }
}