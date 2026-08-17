class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
      Arrays.sort(arr);
    List<List<Integer>>ans=new ArrayList<>();
    List<Integer>ll=new ArrayList<>();
    helper(0,arr,target,ll,ans,0);
    return ans;
    }
    public void helper(int ind,int arr[],int target,List<Integer>ll,List<List<Integer>>ans,int sum){
          if(sum==target){
              ans.add(new ArrayList<>(ll));
              return;
          }
            if(ind==arr.length){
                return;
            }
        
          for(int i=ind;i<arr.length;i++){
              if(i>ind && arr[i]==arr[i-1]){
                continue;
              }
              if(sum>target){
                 break;
              }
                
                ll.add(arr[i]);
                int newSum=sum+arr[i];
                helper(i+1,arr,target,ll,ans,newSum);
                ll.remove(ll.size()-1);
            
          }
    }
}