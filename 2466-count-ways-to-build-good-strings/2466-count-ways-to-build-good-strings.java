class Solution {

    int MOD = 1000000007;
    Integer[] dp;

    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new Integer[high + 1];
        return helper(0, low, high, zero, one);
    }
    public int helper(int len, int low, int high, int zero, int one) {
        if (len > high) {
            return 0;
        }
        if (dp[len] != null) {
            return dp[len];
        }
        int ans = 0;
        if (len >= low) {
            ans = 1;
        }
        ans = (ans + helper(len + zero, low, high, zero, one)) % MOD;
        ans = (ans + helper(len + one, low, high, zero, one)) % MOD;
        return dp[len] = ans;
    }
}