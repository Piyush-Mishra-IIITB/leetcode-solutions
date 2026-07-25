class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int first=-1;
        for(int i=0;i<arr.length;i++){
             if(nums[i]!=arr[i]){
                first=i;
                break;
             }
        }
        int last=-1;
        for(int i=arr.length-1;i>=0;i--){
            if(nums[i]!=arr[i]){
                last=i;
                break;
            }
        }
        if(first==-1){
            return 0;
        }else{
            return last-first+1;
        }
    }
}