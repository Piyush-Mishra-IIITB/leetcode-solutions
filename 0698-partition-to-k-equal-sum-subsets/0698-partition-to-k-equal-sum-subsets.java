class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        List<Integer>ll=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            ll.add(nums[i]);
            sum+=nums[i];
        }
        Collections.sort(ll);
        Collections.reverse(ll);
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=ll.get(i);
        }
        if((sum%k)!=0){
            return false;
        }
       HashSet<Integer>hs=new HashSet<>();
       return helper(0,0,sum/k,arr,0,k,hs);
       
    }
    public boolean helper(int ind,int currSum,int final_sum,int arr[],int times,int k,HashSet<Integer>hs){
        if(times==k-1){
            return true;
        }
        
        if(currSum==final_sum){
            return helper(0,0,final_sum,arr,times+1,k,hs);
        }
        for(int i=ind;i<arr.length;i++){
            if(hs.contains(i)==false){
                if(currSum+arr[i]>final_sum){
                    continue;
                }
                if(currSum+arr[i]<=final_sum){
                    hs.add(i);
                    if(helper(i+1,currSum+arr[i],final_sum,arr,times,k,hs)){
                        return true;
                    }
                    hs.remove(i);
                    while(i+1<arr.length && arr[i]==arr[i+1]){
                       i++;
                    }
                }
            }
        }
        return false;
    }
}