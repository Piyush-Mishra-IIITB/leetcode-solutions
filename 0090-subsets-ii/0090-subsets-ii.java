class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> list = new ArrayList<>();  
        Arrays.sort(nums);   
        helper(0, nums, list, ans);
        return ans;
    }
    public static void helper(int index,int arr[],List<Integer> list,List<List<Integer>> ans){
       ans.add(new ArrayList<>(list));
       for(int i=index;i<arr.length;i++){
        if(i>index && arr[i]==arr[i-1]){
            continue;
        }
        list.add(arr[i]);
        helper(i+1,arr,list,ans);
        list.remove(list.size()-1);
       }

    }
}