class Solution {
    public int numberOfArithmeticSlices(int[] arr) {  
        HashMap<Long,Long>hm[]=new HashMap[arr.length];
        for(int i=0;i<arr.length;i++){
            hm[i]=new HashMap<>();
        }
        int ans=0;
        for(int j=1;j<arr.length;j++){
            for(int i=0;i<j;i++){
                long diff=(long)arr[j]-arr[i];
                long count=hm[i].getOrDefault(diff,0L);
                ans+=count;
                hm[j].put(diff,hm[j].getOrDefault(diff,0L)+count+1);
            }
        }
        return ans;
    }
}