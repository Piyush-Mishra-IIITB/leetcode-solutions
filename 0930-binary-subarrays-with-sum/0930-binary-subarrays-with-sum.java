class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer>hm=new HashMap<>();

        hm.put(0,1);
        int sum=0;
        int op=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int find=sum-goal;
            if(hm.containsKey(find)){
               op+= hm.get(find);
            }

            if(hm.containsKey(sum)){
                hm.put(sum,hm.get(sum)+1);
            }else{
                hm.put(sum,1);
            }
        }
        return op;
    }
}