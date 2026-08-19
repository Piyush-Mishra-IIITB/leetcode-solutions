class Solution {
    public int[] getSumAbsoluteDifferences(int[] arr) {
        int sum[]=new int[arr.length];
        sum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            sum[i]=sum[i-1]+arr[i];
        }
        int output[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int sum1=0;
            int sum2=0;
            if(i>0){
                sum1=sum[i-1];
            }
            if(i<arr.length-1){
                sum2=sum[arr.length-1]-sum[i];
            }
            int left=i;
            int right=arr.length-(i+1);
            int op=(left*arr[i]-sum1)+(sum2-right*arr[i]);
            output[i]=op;
        }
        return output;
    }
}