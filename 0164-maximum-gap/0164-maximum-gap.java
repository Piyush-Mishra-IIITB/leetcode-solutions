class Solution {
    public int maximumGap(int[] arr) {
        Arrays.sort(arr);
        if(arr.length<2){
            return 0;
        }
        int i=0;
        int j=1;
        int ans=arr[1]-arr[0];
        while(j<arr.length){
             ans=Math.max(ans,arr[j]-arr[i]);
             i++;
             j++;
        }
        return ans;
    }
}