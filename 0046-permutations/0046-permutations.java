class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(
        int[] nums,
        boolean[] used,
        List<Integer> curr,
        List<List<Integer>> ans
    ) {

        // permutation is complete
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            // choose
            used[i] = true;
            curr.add(nums[i]);

            // explore
            backtrack(nums, used, curr, ans);

            // undo choice
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}