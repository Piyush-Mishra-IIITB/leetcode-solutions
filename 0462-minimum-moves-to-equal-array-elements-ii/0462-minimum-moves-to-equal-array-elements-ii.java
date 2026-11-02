class Solution {
    public int minMoves2(int[] arr) {
        Arrays.sort(arr);
        int m=arr[arr.length/2];
        int op=0;
        for(int i=0;i<arr.length;i++){
             op+=Math.abs(arr[i]-m);
        }
        return op;
    }
}