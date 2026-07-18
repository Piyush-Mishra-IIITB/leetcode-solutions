class Solution {
    public int splitArray(int[] arr, int k) {
        if(arr.length<k){
            return -1;
        }
        int start=0;
        int end=0;
        for(int i=0;i<arr.length;i++){
            start=Math.max(start,arr[i]);
            end+=arr[i];
        }
       while(start<=end){
          int mid=start+(end-start)/2;
             if(helper(mid,arr,k)){
                end=mid-1;
             }else{
                start=mid+1;
             }
       }
       return start;
    }
    public boolean helper(int largestSum,int arr[],int n){
        int currSum=arr[0];
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(currSum+arr[i]<=largestSum){
                currSum+=arr[i];
            }else{
                currSum=arr[i];
               count++;
            }
        }
        return count<=n;
    }
}