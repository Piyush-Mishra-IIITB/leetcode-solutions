class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int end=arr[0][1];
        int length=1;
        for(int i=1;i<arr.length;i++){
            int a[]=arr[i];
            if(end>a[0]){
                end=Math.min(end,a[1]);
            }else{
                end=a[1];
                length++;
            }
        }
        return arr.length-length;
    }
}

