class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums4.length;i++){
               for(int j=0;j<nums3.length;j++){
                   int val=nums3[j]+nums4[i];
                   if(hm.containsKey(val)){
                    hm.put(val,hm.get(val)+1);
                   }else{
                    hm.put(val,1);
                   }
               }
        }
        int n=nums1.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<nums2.length;j++){
                    int sum=nums1[i]+nums2[j];
                    if(hm.containsKey(-(sum))){
                      ans+=hm.get(-(sum));
                    }
                }
        }
        return ans;
    }
}