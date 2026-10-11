class Solution {
    public int sumOfSquares(int[] arr) {
        int op=0;
        for(int i=1;i<=arr.length;i++){
            if(arr.length % i==0){
                System.out.println(i);
                op+=arr[i-1]*arr[i-1];
            }
        }
        return op;
    }
}