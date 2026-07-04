class Solution {
    Long dp[][][][];
    public long maximumProfit(int[] prices, int k) {
        dp = new Long[prices.length][k + 1][2][2];
        return helper(0, k, 0, 0, prices);
    }
    public long helper(int ind, int k, int buy, int sell, int arr[]) {
        if (ind == arr.length) {
            if (buy == 0 && sell == 0) {
                return 0;
            }
            return Long.MIN_VALUE / 2;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[ind][k][buy][sell] != null) {
            return dp[ind][k][buy][sell];
        }
        long ans = 0;
        if (buy == 1) {
            long se = arr[ind] + helper(ind + 1, k - 1, 0, sell, arr);
            long skip = helper(ind + 1, k, 1, sell, arr);
            ans = Math.max(skip, se);
        } else if (sell == 1) {
            long s = -arr[ind] + helper(ind + 1, k - 1, buy, 0, arr);
            long b = helper(ind + 1, k, buy, 1, arr);
            ans = Math.max(s, b);
        } else {
            long a = -arr[ind] + helper(ind + 1, k, 1, sell, arr);
            long bb = arr[ind] + helper(ind + 1, k, buy, 1, arr);
            long c = helper(ind + 1, k, buy, sell, arr);
            ans = Math.max(Math.max(a, bb), c);
        }
        return dp[ind][k][buy][sell] = ans;
    }
}