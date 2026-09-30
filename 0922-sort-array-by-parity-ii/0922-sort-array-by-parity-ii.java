class Solution {
    public int[] sortArrayByParityII(int[] arr) {
        int odd=1;
        int even=0;
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            if(curr%2==0){
                ans[even]=curr;
                even+=2;
            }else{
                ans[odd]=curr;
                odd+=2;
            }
        }
        return ans;
    }
}