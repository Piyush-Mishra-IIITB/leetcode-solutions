class Solution {
    public int maxProduct(int[] arr) {
        int maxr=arr[0];
        int minr=arr[0];
        int min=arr[0];
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int v1=curr*maxr;
            int v2=curr*minr;
            maxr = Math.max(curr, Math.max(v1, v2));
            minr = Math.min(curr, Math.min(v1, v2));
            min=Math.min(min,minr);
            max=Math.max(max,maxr);
        }
        return Math.max(min,max);
    }
}