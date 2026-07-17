class Solution {
    public int smallestDivisor(int[] arr, int threshold) {
       int start=1;
       int end=-1;
       for(int i=0;i<arr.length;i++){
        end=Math.max(end,arr[i]);
       }
       while(start<=end){
        int mid=start+(end-start)/2;
         if(helper(mid,arr,threshold)){
            end=mid-1;
         }else{
            start=mid+1;
         }
       }
       return start;
    }
    public boolean helper(int divisor,int arr[],int threshold){
        int sum=0;
        for(int i=0;i<arr.length;i++){
           sum += (int) Math.ceil(arr[i] * 1.0 / divisor);
        }
        return sum<=threshold;
    }
}