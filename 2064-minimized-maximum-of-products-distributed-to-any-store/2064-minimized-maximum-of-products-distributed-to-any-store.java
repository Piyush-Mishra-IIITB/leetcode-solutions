class Solution {
    public int minimizedMaximum(int n, int[] arr) {
        int start=1;
        int end=-1;
        for(int i=0;i<arr.length;i++){
            end=Math.max(end,arr[i]);
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(helper(mid,arr,n)){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
    public boolean helper(int possible,int arr[],int n){
        int count=0;
        for(int i=0;i<arr.length;i++){
            count+=(int)Math.ceil(arr[i]*1.0/possible);
        }
        return count<=n;
    }
}