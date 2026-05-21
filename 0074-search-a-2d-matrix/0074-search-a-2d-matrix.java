class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        for(int i=0;i<arr.length;i++){
            if(helper(arr[i],target)){
                return true;
            }
        }
        return false;
    }
    public boolean helper(int arr[],int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return true;
            }
            else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
}
