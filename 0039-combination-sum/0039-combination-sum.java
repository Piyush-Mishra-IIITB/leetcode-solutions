class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        helper(candidates,target,0,ans,ll,0);
        return ans;
    }
    public static void helper(int arr[],int target,int sum,List<List<Integer>>ans,List<Integer>ll,int i){
    if(sum==target){
        ans.add(new ArrayList<>(ll));
        return;
    }
    if(i==arr.length|| sum>target ){
        return;
    }
    ll.add(arr[i]);
    helper(arr,target,sum+arr[i],ans,ll,i);
    ll.remove(ll.size()-1);
    helper(arr,target,sum,ans,ll,i+1);
}
}