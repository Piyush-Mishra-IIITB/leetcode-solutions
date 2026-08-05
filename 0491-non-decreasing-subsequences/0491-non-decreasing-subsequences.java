class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        HashSet<List<Integer>>hs =new HashSet<>();
        helper(0,-1,nums,ans,ll,hs);
        return ans;
    }
    public void helper(int ind,int prev,int arr[],List<List<Integer>>ans,List<Integer>ll,HashSet<List<Integer>>hs){
        if(ind==arr.length){
            if(ll.size()>=2){
               if(!hs.contains(ll)){
                hs.add(new ArrayList<>(ll));
                ans.add(new ArrayList<>(ll));
               }
            }
            return;
        }

        //skip
        helper(ind+1,prev,arr,ans,ll,hs);
        //pick
        if(prev==-1 || arr[prev]<=arr[ind]){
             ll.add(arr[ind]);
             helper(ind+1,ind,arr,ans,ll,hs);
             ll.remove(ll.size()-1);
        }
    }
}