class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long ans=Long.MAX_VALUE;
        long total=0;
        for(int i=0;i<beans.length;i++){
              total+=beans[i];
        }
       for(int i=0;i<beans.length;i++){
          ans=Math.min(ans,helper(beans,i,total));
       }
        return ans;
    }
    public long helper(int arr[],int ind,long total){
         return total-(long)arr[ind]*(arr.length-ind);
    }
}