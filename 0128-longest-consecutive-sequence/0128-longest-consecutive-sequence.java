class Solution {
    public int longestConsecutive(int[] arr) {
       
       HashSet<Integer>hs=new HashSet<>();
       for(int i=0;i<arr.length;i++){
        hs.add(arr[i]);
       }
       int ans=0;
       
       for(Integer it:hs){
           
           if(!hs.contains(it-1)){
            
            int curr=it;
            int length=1;
            while(hs.contains(curr+1)){
                curr++;
                length++;
            }
            ans=Math.max(ans,length);

           }
       }
       return ans;
     
    }
}