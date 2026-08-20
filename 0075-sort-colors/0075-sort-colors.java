class Solution {
    public void sortColors(int[] arr) {
        int low=0;
        int high=arr.length-1;
        int mid=0;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else if(arr[mid]==2){
                swap(arr,high,mid);
                high--;
            }
            
        }

    }
    public void swap(int arr[],int low,int med){
        int t=arr[low];
        arr[low]=arr[med];
        arr[med]=t;
    }
}