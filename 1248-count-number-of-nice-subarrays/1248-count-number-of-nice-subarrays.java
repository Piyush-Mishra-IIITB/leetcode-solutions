class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        return helper(arr,k)-helper(arr,k-1);
    }
    public int helper(int arr[],int k){
           
        int count=0;
        int low=0;
        int op=0;
        for(int high=0;high<arr.length;high++){
            int curr=arr[high];
            if(curr%2!=0){
                count++;
            }

            while(count>k){
                int val=arr[low];
                if(val%2!=0){
                    count--;
                }
                low++;
            }
            op+=high-low+1;
        }
        return op;
    }
}