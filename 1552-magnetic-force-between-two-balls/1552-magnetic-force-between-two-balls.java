class Solution {
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        if(arr.length<m){
            return -1;
        }
        
        int start=1;
        int end=arr[arr.length-1]-arr[0];
        while(start<=end){
            int mid=start+(end-start)/2;
            if(helper(mid,arr,m)){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return end;
    }
    public boolean helper(int force,int arr[],int m){
        int prev=arr[0];
        m--;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-prev>=force){
                prev=arr[i];
                m--;
            }
        }
        return m<=0;
    }
}