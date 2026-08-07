class Solution {
    public int maxAbsoluteSum(int[] arr) {
        int min=arr[0];
        int var1=arr[0];
        int max=arr[0];
        int var2=arr[0];
        for(int i=1;i<arr.length;i++){
            int v1=arr[i];
            int v2=var1+arr[i];
            int v3=var2+arr[i];
            var1=Math.min(v1,v2);
            min=Math.min(var1,min);
            var2=Math.max(v1,v3);
            max=Math.max(max,var2);
        }
        return Math.max(max,Math.abs(min));
    }
}