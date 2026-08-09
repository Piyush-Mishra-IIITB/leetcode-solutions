class Solution {
    public boolean canJump(int[] arr) {
        int start=arr.length-2;
        int toReach=arr.length-1;
        for(int i=start;i>=0;i--){
            if(arr[i]+i>=toReach){
                toReach=i;
            }
        }
        return toReach==0;
    }
}
