class Solution {
    public int[] twoSum(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;
        int[] output = new int[2];
        while(start<=end){
            if((arr[start]+arr[end])==target){
                output[0]=start+1;
                output[1]=end+1;
                return output;
            }
            else if((arr[start]+arr[end])>target){
                end--;
            }else{
                start++;
            }
        }
       return output;
    }
}
