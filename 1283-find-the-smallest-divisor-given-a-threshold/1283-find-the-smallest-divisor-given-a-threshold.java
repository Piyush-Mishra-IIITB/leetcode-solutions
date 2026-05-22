class Solution {
    public int smallestDivisor(int[] arr, int threshold) {
        int end=arr[0];
        for(int i=0;i<arr.length;i++){
            end=Math.max(arr[i],end);
        }
        int start=1;
        int output=end;
        while(start<=end){
           int mid=start+(end-start)/2;
           if(helper(arr,mid)<=threshold){
              output=Math.min(output,mid);
              end=mid-1;
           }else{
            start=mid+1;
           }
        }
        return output;
    } 
    public int helper(int arr[],int k){
        int counter=0;
        for(int i=0;i<arr.length;i++){
            counter+=Math.ceil(arr[i]/(double)k);
        }
        return counter;
    }
}