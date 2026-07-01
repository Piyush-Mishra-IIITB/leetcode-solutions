class Solution {
    public int maxProduct(int[] arr) {
        int min_end=arr[0];
        int var_min=arr[0];
        int max_end=arr[0];
        int var_max=arr[0];
        int product=arr[0];

        for(int i=1;i<arr.length;i++){
            int v1=arr[i];
            int v2=var_max*arr[i];
             int v3=var_min*arr[i];
            var_max=Math.max(v3,Math.max(v2,v1));
            max_end=Math.max(var_max,max_end);
           
            var_min=Math.min(v2,Math.min(v1,v3));
            min_end=Math.min(var_min,min_end);
            product=Math.max(max_end,min_end);
        }

        return product;
    }
}