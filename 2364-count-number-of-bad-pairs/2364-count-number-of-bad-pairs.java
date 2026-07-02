class Solution {
    public long countBadPairs(int[] arr) {
        HashMap<Long,Long>hm=new HashMap<>();
        long count=0;
        for(int i=0;i<arr.length;i++){
             long find=arr[i]-i;
             if(hm.containsKey(find)){
                 count=count+i-hm.get(find);
             }else{
                count+=i;
             }

             if(hm.containsKey(find)){
                hm.put(find,hm.get(find)+1);
             }else{
                hm.put(find,1l);
             }
        }
        return count;
    }
}