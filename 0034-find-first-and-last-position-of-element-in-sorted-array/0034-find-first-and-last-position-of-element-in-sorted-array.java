class Solution {
    public int[] searchRange(int[] arr, int target) {
        int first=-1;
        int last=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                first=mid;
                end=mid-1;
            }else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        int start2=0;
        int end2=arr.length-1;
        while(start2<=end2){
            int mid=start2+(end2-start2)/2;
            if(arr[mid]==target){
                last=mid;
                start2=mid+1;
            }else if(arr[mid]>target){
                end2=mid-1;
            }else{
                start2=mid+1;
            }
        }
        int ans[]=new int[2];
        ans[0]=first;
        ans[1]=last;
        return ans;
    }  
}
