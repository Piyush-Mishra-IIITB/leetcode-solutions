class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
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
            while(hm.get(curr)>k){
                int val=hm.get(arr[low]);
                hm.remove(arr[low]);
                if(val>1){
                    hm.put(arr[low],val-1);
                }
                low++;
            }
            System.out.println("high" + high + "low" +low);
            ans=Math.max(ans,high-low+1);
        } 
        
        return ans;
    }
}