class Solution {
    public int minMoves(int[] arr) {
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            max=Math.max(arr[i],max);
        }
        int op=0;
        for(int i=0;i<arr.length;i++){
           op+=max-arr[i];
        }
        return op;
    }
}