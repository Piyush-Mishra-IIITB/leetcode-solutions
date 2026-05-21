class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int row=arr.length;
        int col=arr[0].length;
        int i=0;
        int j=col-1;
        while(i<row && j>=0){
            if(arr[i][j]==target){
                return true;
            }
            else if(arr[i][j]>target){
                j--;
            }else{
                i++;
            }
        }
        return false;  
    }
}