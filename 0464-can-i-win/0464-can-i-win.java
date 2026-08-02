class Solution {
    Boolean[] dp;

    public boolean canIWin(int max, int desired) {
        if (desired <= 0) return true;

        int total = max * (max + 1) / 2;
        if (total < desired) return false;

        dp = new Boolean[1 << (max + 1)];
        return helper(0, desired, max);
    }

    boolean helper(int mask, int desired, int max) {
        if (dp[mask] != null)
            return dp[mask];

        int currSum = 0;
        for (int i = 1; i <= max; i++) {
            if ((mask & (1 << i)) != 0)
                currSum += i;
        }

        boolean player1Turn = (Integer.bitCount(mask) % 2 == 0);

        if (currSum >= desired)
            return dp[mask] = !player1Turn;

        if (player1Turn) {
            for (int i = 1; i <= max; i++) {
                if ((mask & (1 << i)) == 0) {
                    if (helper(mask | (1 << i), desired, max))
                        return dp[mask] = true;
                }
            }
            return dp[mask] = false;
        } else {
            for (int i = 1; i <= max; i++) {
                if ((mask & (1 << i)) == 0) {
                    if (!helper(mask | (1 << i), desired, max))
                        return dp[mask] = false;
                }
            }
            return dp[mask] = true;
        }
    }
}