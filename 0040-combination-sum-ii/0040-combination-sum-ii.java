class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {

        Arrays.sort(arr);
        List<List<Integer>> ans=new ArrayList<>();
       List<Integer>ll=new ArrayList<>();
       helper(arr,ans,ll,0,target);
       return ans;
    }
    public void helper(int arr[],List<List<Integer>> ans, List<Integer>ll,int ind,int target){
      if(target==0){
        ans.add(new ArrayList<>(ll));
        return;
      }
      for(int i=ind;i<arr.length;i++){
          if(arr[i]>target){
            break;
          }
          if(i>ind && arr[i]==arr[i-1]){
            continue;
          }
          ll.add(arr[i]);
          helper(arr,ans,ll,i+1,target-arr[i]);
          ll.remove(ll.size()-1);
      }
    }
}