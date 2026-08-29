class Solution {
    public int findTheWinner(int n, int k) {
       List<Integer>ll=new ArrayList<>();
       for(int i=1;i<=n;i++){
        ll.add(i);
       }
       return helper(ll,0,k);
    }
    public int helper(List<Integer>ll,int start,int k){
        if(ll.size()==1){
            return ll.get(0);
        }
            int indexToremove=(start+k-1)%ll.size();
            ll.remove(indexToremove);
            return helper(ll,indexToremove,k);
       
    }
}