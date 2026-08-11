class Solution {
    int globalVar=0;
    public int longestMountain(int[] arr) {
        boolean havSeen=false;
        List<Integer>peak=new ArrayList<>();
        for(int i=1;i<arr.length-1;i++){
              if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                peak.add(i);
              }
        }
        int ans=0;
        for(Integer it:peak){
            int left=it;
            int right=it;
            while(left>0 && arr[left]>arr[left-1]){
                left--;
            }
            while(right<arr.length-1 && arr[right]>arr[right+1]){
                right++;
            }
           ans=Math.max(ans,right-left+1);
        }
        return ans;
       
    }
}