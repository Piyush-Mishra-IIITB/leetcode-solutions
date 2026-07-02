class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
       int n=nums.length;
       long count=0;
       for(int i=0;i<nums.length;i++){
        int lowe=helper(i+1,n-1,nums,lower-nums[i]);
        int higher=helper2(i+1,n-1,nums,upper-nums[i]);
        count+=higher-lowe;
       }
       return count;}
       public int helper(int start,int end,int arr[],int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>=target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
       }
       public int helper2(int start,int end,int arr[],int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<=target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;
       }
}