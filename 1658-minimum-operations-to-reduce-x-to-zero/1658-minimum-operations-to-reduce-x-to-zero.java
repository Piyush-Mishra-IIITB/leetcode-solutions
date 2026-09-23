class Solution {
    public int minOperations(int[] arr, int x) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum<x){
            return -1;
        }
        if(sum==x){
            return arr.length;
        }
        int target=sum-x;
        int runninngSum=0;
        int length=Integer.MIN_VALUE;
        int low=0;
        for(int high=0;high<arr.length;high++){
             runninngSum+=arr[high];
             while(runninngSum>=target && low<arr.length){
                if(runninngSum==target){
                    length=Math.max(length,high-low+1);
                }
                runninngSum-=arr[low];
                low++;
             }
        }
        if(length==Integer.MIN_VALUE){
            return -1;
        }
        return arr.length-length;
    }
}