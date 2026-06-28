class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0]=arr[0]-(arr[0]-1);
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]>1){
                arr[i]=arr[i-1]+1;
            }
        }
        for(int i=0;i<arr.length;i++){
           System.out.println(arr[i]);
        }
        return arr[arr.length-1];
    }
}