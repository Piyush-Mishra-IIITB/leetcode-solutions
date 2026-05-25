class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        boolean vis[]=new boolean[nums.length];
        helper(nums,ans,ll,vis);
        return ans;

    }
    public void helper(int arr[],List<List<Integer>>ans,List<Integer>ll,boolean vis[]){
        if(ll.size()==arr.length){
            ans.add(new ArrayList<>(ll));
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(vis[i]==false){
                ll.add(arr[i]);
                vis[i]=true;
                helper(arr,ans,ll,vis);
                ll.remove(ll.size()-1);
                vis[i]=false;
        }
    }
}}