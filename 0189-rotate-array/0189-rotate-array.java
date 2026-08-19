class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        helper(nums,0,nums.length-1);
        helper(nums,0,k-1);
        helper(nums,k,nums.length-1);
    }
    public void helper(int arr[],int i,int j){
        while(i<j){
            int t=arr[i];
            arr[i]=arr[j];
            arr[j]=t;
            i++;
            j--;
        }
    }
}