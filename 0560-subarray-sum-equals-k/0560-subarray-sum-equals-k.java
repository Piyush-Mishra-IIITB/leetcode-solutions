class Solution {
    public int subarraySum(int[] arr, int k) {
      HashMap<Integer,Integer>hs=new HashMap<>();
      hs.put(0,1);
      int sum=0;
      int count=0;
      for(int i=0;i<arr.length;i++){
         sum+=arr[i];
         int find=sum-k;
         if(hs.containsKey(find)){
              count+=hs.get(find);
         }
         if(hs.containsKey(sum)){
            hs.put(sum,hs.get(sum)+1);
         }
         else{
            hs.put(sum,1);
         }
      }
      return count;
    }

}
