class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int a=0;
        for(int i=0;i<arr.length;i++){
            a+=arr[i];
        }
        if(a<target){
            return 0;
        }
        int sum=0;
        int i=0;
        int ans=arr.length;
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            while(sum>=target){
                ans=Math.min(ans,j-i+1);
                sum=sum-arr[i];
                i++;
            }
        }
        return ans;
    }
}
