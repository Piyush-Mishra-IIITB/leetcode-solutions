class Solution {
    public int maxChunksToSorted(int[] arr) {
        return helper(arr,0);
    }
    public int helper(int arr[],int ind){
       if(ind==arr.length){
        return 0;
       }
       int ans=0;
       for(int i=ind;i<arr.length;i++){
        if(help(ind,i,arr)){
           ans=Math.max(ans,1+helper(arr,i+1));
        }
       }
       return ans;
    }
    public boolean help(int a,int b,int arr[]){
        List<Integer>ll=new ArrayList<>();
        for(int i=a;i<=b;i++){
            ll.add(arr[i]);
        }
        Collections.sort(ll);
        int p=0;
        for(int i=a;i<=b;i++){
           if(ll.get(p)!=i){
            return false;
           }
           p++;
        }
        return true;
    }
}