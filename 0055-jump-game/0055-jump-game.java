class Solution {
    public boolean canJump(int[] arr) {
        int toReach=arr.length-1;
        int curr=0;
        for(int i=0;i<arr.length;i++){
            curr=Math.max(arr[i]+i,curr);
            if(curr==i && i!=arr.length-1){
                return false;
            }
        }
        return true;

    }
}