class Solution {

    public List<List<Integer>> subsets(int[] arr) {
     List<List<Integer>>ll=new ArrayList<>();
     List<Integer>ans=new ArrayList<>();
     helper(ll,ans,arr,0);
     return ll;   
    }
    public void helper(List<List<Integer>>ll,List<Integer>ans,int arr[],int i){

        if(i==arr.length){
            ll.add(new ArrayList<>(ans));
            return;
        }
        ans.add(arr[i]);
        helper(ll,ans,arr,i+1);
        ans.remove(ans.size()-1);
        helper(ll,ans,arr,i+1);
    }
}
