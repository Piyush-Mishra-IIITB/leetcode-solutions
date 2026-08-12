class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        List<Integer>ll=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            ll.add(arr[i]);
        }
        Collections.sort(ll);
        Collections.reverse(ll);
        int i=0;
        int j=ll.size()-1;
        int ans=0;
         while(i<=j){
            if(ll.get(i)+ll.get(j)<=limit){
                j--;
                i++;
            }else{
                i++;
            }
            ans++;
         }
         return ans;

    }
}