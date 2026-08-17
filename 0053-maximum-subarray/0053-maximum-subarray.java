class Solution {
    public int maxSubArray(int[] arr) {
        int v1=arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            int v2=arr[i];
            v1=arr[i]+v1;
            v1=Math.max(v1,v2);
            max=Math.max(v1,max);
        }
        return max;
    }
}