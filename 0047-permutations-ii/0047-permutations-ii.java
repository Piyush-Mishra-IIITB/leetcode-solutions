class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> ll = new ArrayList<>();

        boolean vis[] = new boolean[nums.length];

        Arrays.sort(nums);

        permute(nums, ans, ll, vis);

        return ans;
    }

    private static void permute(int[] arr,
                                List<List<Integer>> ans,
                                List<Integer> ll,
                                boolean vis[]) {

        if(ll.size() == arr.length){
            ans.add(new ArrayList<>(ll));
            return;
        }

        for(int i = 0; i < arr.length; i++){

            // skip duplicates
            if(i > 0 && arr[i] == arr[i-1] && vis[i-1] == false){
                continue;
            }

            if(vis[i] == false){

                ll.add(arr[i]);

                vis[i] = true;

                permute(arr, ans, ll, vis);

                ll.remove(ll.size() - 1);

                vis[i] = false;
            }
        }
    }
}