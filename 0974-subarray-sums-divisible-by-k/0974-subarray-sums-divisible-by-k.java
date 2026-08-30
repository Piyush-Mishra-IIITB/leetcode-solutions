class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,1);
        int sum=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int find=((sum%k)+k)%k;
            System.out.println(find);
            if(hm.containsKey(find)){
                ans+=hm.get(find);
            }
            if(hm.containsKey(find)){
                hm.put(find,hm.get(find)+1);
            }else{
                hm.put(find,1);
            }
        }
        return ans;
    }
}