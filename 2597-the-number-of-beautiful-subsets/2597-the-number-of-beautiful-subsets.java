class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        Arrays.sort(nums);
        helper(0,ll,ans,nums,k);
        return ans.size();
    }
    public void helper(int ind,List<Integer>ll,List<List<Integer>>ans,int nums[],int k){
        if(ind==nums.length){
            if (!ll.isEmpty()) {
        ans.add(new ArrayList<>(ll));
    }
            return;
        }
        boolean poss=true;
         for(int it:ll){
          if(nums[ind]-k==it){
             poss=false;
         }
       }
        if(poss){
            ll.add(nums[ind]);
            helper(ind+1,ll,ans,nums,k);
            ll.remove(ll.size()-1);}
        helper(ind+1,ll,ans,nums,k);
    }
}