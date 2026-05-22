class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int largest=arr[0];
        int smallest=1;
        for(int i=0;i<arr.length;i++){
             largest=Math.max(largest,arr[i]);
        }
        int output=Integer.MAX_VALUE;
        while(smallest<=largest){
            int mid=smallest+(largest-smallest)/2;
            if(helper(arr,mid)<=h){
                 output=Math.min(output,mid);
                 largest=mid-1;
            }
            else{
                smallest=mid+1;
            }
        }
        return output;
    }
    public int helper(int arr[],int j){
        int hour=0;
        for(int i=0;i<arr.length;i++){
           hour+= Math.ceil(arr[i]/(double)j);
        }
        return hour;
    }
}