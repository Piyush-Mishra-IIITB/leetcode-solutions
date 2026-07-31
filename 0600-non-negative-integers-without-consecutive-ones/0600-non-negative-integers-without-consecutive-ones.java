class Solution {
    Integer dp[][][];
    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n);
        dp = new Integer[s.length()][2][2];
        return helper(0, 1, 0, s);
    }
    public int helper(int ind, int tight, int prev, String s) {
        if (ind == s.length()) {
            return 1;
        }
        if (dp[ind][tight][prev] != null) {
            return dp[ind][tight][prev];
        }
        int up = (tight == 1) ? s.charAt(ind) - '0' : 1;
        int ans = 0;
        for (int bit = 0; bit <= up; bit++) {
            if (prev == 1 && bit == 1) {
                continue;
            }
            int newTight = (tight == 1 && bit == up) ? 1 : 0;
            ans += helper(ind + 1, newTight, bit, s);
        }
        return dp[ind][tight][prev] = ans;
    }
}