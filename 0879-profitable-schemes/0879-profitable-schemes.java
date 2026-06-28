class Solution {
    int MOD = 1000000007;
    Integer[][][] dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new Integer[group.length][n + 1][minProfit + 1];
        return helper(0, n, minProfit, group, profit);
    }

    public int helper(int ind, int members, int profitLeft, int[] group, int[] profit) {

        if (ind == group.length) {
            return profitLeft == 0 ? 1 : 0;
        }

        if (dp[ind][members][profitLeft] != null) {
            return dp[ind][members][profitLeft];
        }
        int notTake = helper(ind + 1, members, profitLeft, group,profit);
        int take = 0;

        if (group[ind] <= members) {
            take = helper( ind + 1, members - group[ind], Math.max(0, profitLeft - profit[ind]), group,profit);
        }

        return dp[ind][members][profitLeft] = (take + notTake) % MOD;
    }
}