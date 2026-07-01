class Solution {
    public int longestOnes(int[] nums, int k) {
        boolean flag=false;
        for(int j=0;j<nums.length;j++){
            if(nums[j]==1){
                flag=true;

            }
        }
        if(flag==false ){
            return k;
        }
        HashMap<Integer,Integer>hm=new HashMap<>();
        int i=0;
        int ans=0;
        for(int j=0;j<nums.length;j++){
            int curr=nums[j];
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
            while(hm.size()==2 && hm.get(0)>k){
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