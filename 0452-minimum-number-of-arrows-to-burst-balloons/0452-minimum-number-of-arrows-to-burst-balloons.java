class Solution {
    public int findMinArrowShots(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int first=arr[0][1];
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<=first){
                first=Math.min(first,arr[i][1]);
            }else{
                first=arr[i][1];
                 count++;
            }
        }
        return count;
    }
}