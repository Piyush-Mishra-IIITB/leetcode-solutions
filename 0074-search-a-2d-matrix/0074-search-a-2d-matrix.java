class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n=arr.length;
        int m=arr[0].length;
        int end=n*m-1;
        int start=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            int row=mid/m;
            int col=mid%m;
            if(arr[row][col]==target){
                return true;
            }else if(arr[row][col]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
}