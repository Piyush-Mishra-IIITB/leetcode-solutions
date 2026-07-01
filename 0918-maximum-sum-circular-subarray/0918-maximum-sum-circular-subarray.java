class Solution {
    public int maxSubarraySumCircular(int[] arr) {

       int max_sum=arr[0];
       int var_max=arr[0];
       int min_sum=arr[0];
       int var_min=arr[0];
       int total=arr[0];
        for (int i = 1; i < arr.length; i++) {
           total+=arr[i];

           int v1=arr[i];
           int v2=var_max+arr[i];
           var_max=Math.max(v1,v2);
           max_sum=Math.max(var_max,max_sum);
           int v3=var_min+arr[i];
           var_min=Math.min(v1,v3);
           min_sum=Math.min(var_min,min_sum);
        }
        if(max_sum<0){
            return max_sum;
        }
        return Math.max(max_sum, total - min_sum);
    }
}
