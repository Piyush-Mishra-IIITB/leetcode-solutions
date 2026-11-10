class Solution {
    Integer dp[];

    public int climbStairs(int n, int[] costs) {
        dp = new Integer[n];
        return helper(n-1, -1, costs);
    }

    public int helper(int n, int curr, int arr[]) {
        if (curr == n) return 0;

        if (dp[curr+1] != null) return dp[curr+1];

        int first = Integer.MAX_VALUE;
        if (curr+1 <= n) {
            first = arr[curr+1] + 1 + helper(n, curr+1, arr);
        }

        int second = Integer.MAX_VALUE;
        if (curr+2 <= n) {
            second = arr[curr+2] + 4 + helper(n, curr+2, arr);
        }

        int third = Integer.MAX_VALUE;
        if (curr+3 <= n) {
            third = arr[curr+3] + 9 + helper(n, curr+3, arr);
        }

        return dp[curr+1] = Math.min(first, Math.min(second, third));
    }
}