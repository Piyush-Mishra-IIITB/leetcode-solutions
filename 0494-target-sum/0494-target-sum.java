class Solution {
    Integer dp[][];

    public int findTargetSumWays(int[] nums, int target) {
        dp = new Integer[nums.length][2001];
        return helper(0, target, nums);
    }

    public int helper(int ind, int target, int arr[]) {

        // target outside possible range
        if (target < -1000 || target > 1000) {
            return 0;
        }

        if (ind == arr.length - 1) {
            int count = 0;

            if (target == arr[ind])
                count++;

            if (target == -arr[ind])
                count++;

            return count;
        }

        if (dp[ind][target + 1000] != null) {
            return dp[ind][target + 1000];
        }

        int plus = helper(ind + 1, target - arr[ind], arr);
        int minus = helper(ind + 1, target + arr[ind], arr);

        return dp[ind][target + 1000] = plus + minus;
    }
}