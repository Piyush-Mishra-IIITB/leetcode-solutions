class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    public int helper(int arr[],int k){
        HashMap<Integer,Integer>hm=new HashMap<>();
       int low=0;
       int ans=0;
        for(int high=0;high<arr.length;high++){
            int curr=arr[high];
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }

            while(hm.size()>k){
                 int get=hm.get(arr[low]);
                 hm.remove(arr[low]);
                 if(get>1){
                    hm.put(arr[low],get-1);
                 }
                 low++;
            }
           ans+=high-low+1;
        }
        return ans;
    }
}