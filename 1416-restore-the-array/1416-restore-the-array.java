class Solution {
    static final int MOD = 1_000_000_007;
    Integer[] dp;
    public int numberOfArrays(String s, int k) {
        dp = new Integer[s.length()];
        return helper(0, s, k);
    }
    public int helper(int ind, String s, int k) {
        if (ind == s.length()) {
            return 1;
        }
        if (s.charAt(ind) == '0') {
            return 0;
        }
        if (dp[ind] != null) {
            return dp[ind];
        }
        long num = 0;
        long ans = 0;
        for (int i = ind; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > k) {
                break;
            }
            ans = (ans + helper(i + 1, s, k)) % MOD;
        }
        return dp[ind] = (int) ans;
    }
}