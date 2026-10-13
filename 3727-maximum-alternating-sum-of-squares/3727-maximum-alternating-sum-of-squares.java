class Solution {
    public long maxAlternatingSum(int[] arr) {
         int n=arr.length;
        int newarr[]=new int[n];
        for(int i=0;i<n;i++){ 
            newarr[i]=Math.abs(arr[i]);
        }
        Arrays.sort(newarr);
       
            long sum=0;
            for(int i=0;i<n/2;i++){
                 sum-=newarr[i]*newarr[i];
            }
            for(int i=n/2;i<n;i++){
                sum+=newarr[i]*newarr[i];
            }
        return sum;
    }
}