class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<Integer>ll=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        helper(ll,ans,0,target,arr,0);
        return ans;
    }
    public void helper(List<Integer>ll,List<List<Integer>>ans,int currSum,int target,int arr[],int ind){
        if(ind==arr.length){
            return;
        }
        if(currSum==target){
                ans.add(new ArrayList<>(ll));
            return;
            }
        // skip
        helper(ll,ans,currSum,target,arr,ind+1);

        // pick
        if(currSum+arr[ind]<=target){
           ll.add(arr[ind]);
           helper(ll,ans,currSum+arr[ind],target,arr,ind);
           ll.remove(ll.size()-1);
        }
        
    }
}