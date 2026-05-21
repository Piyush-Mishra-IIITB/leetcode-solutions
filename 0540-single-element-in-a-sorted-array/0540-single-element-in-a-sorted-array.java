class Solution {
    public int singleNonDuplicate(int[] arr) {
       int N=arr.length;
       if(N==1){
        return arr[0];
       }
    if(arr[0] != arr[1]) {
            return arr[0];
        }

        if(arr[N-1] != arr[N-2]) {
            return arr[N-1];
        }
     int start=1;
     int end=arr.length-2;
     while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
            return arr[mid];
        }
        if(mid %2==0 && arr[mid]==arr[mid+1] || mid%2==1 && arr[mid]==arr[mid-1]){
            start=mid+1;
        }else{
            end=mid-1;
        }
     }
return 69;
    }
}