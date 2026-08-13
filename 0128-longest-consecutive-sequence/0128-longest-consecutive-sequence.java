class Solution {
    public int longestConsecutive(int[] arr) {
       HashSet<Integer>hs=new HashSet<>();
       for(int i=0;i<arr.length;i++){
        hs.add(arr[i]);
       }
      int length=0;
      int ans=0;
       for(int i=0;i<arr.length;i++){
           if(!hs.contains(arr[i])){
              continue;
           }
           if(hs.contains(arr[i]-1)){
              continue;
           }
           int curr=arr[i];
           while(hs.contains(curr)){
              length++;
              hs.remove(curr);
              curr=curr+1;
              ans=Math.max(ans,length);
           }
           length=0;

       }
       return ans;
    }
}