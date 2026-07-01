class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int nums[],int k){
        int ans=0;
        int i=0;
        int odd=0;
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int j=0;j<nums.length;j++){
             int curr=nums[j];
             if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
             }else{
                hm.put(curr,1);
             }
             if(curr%2!=0){
                   odd++;
             }
             while(odd>k){
                int val=hm.get(nums[i]);
                hm.remove(nums[i]);
                if(val>1){
                    hm.put(nums[i],val-1);
                }
                if(nums[i]%2!=0){
                    odd--;
                }
                i++;
             }
             ans+=j-i+1;
        }
        return ans;
    }
}