class Solution {
    public int minimumSum(int[] arr) {
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<arr.length-1;i++){
            int left=arr[i];
            int right=arr[i];
            for(int j=i-1;j>=0;j--){
                left=Math.min(left,arr[j]);
            }
            for(int j=i+1;j<arr.length;j++){
                right=Math.min(right,arr[j]);
            }
            if(left==arr[i] || right==arr[i]){
                continue;
            }
            ans=Math.min(ans,left+right+arr[i]);

        }
        return ans==Integer.MAX_VALUE? -1:ans;
        
    }
}