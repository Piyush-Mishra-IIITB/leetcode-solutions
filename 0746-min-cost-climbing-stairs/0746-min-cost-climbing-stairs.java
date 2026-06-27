class Solution {
    int dp1[];
    int dp2[];

    public int minCostClimbingStairs(int[] cost) {
        dp1 = new int[cost.length];
        dp2 = new int[cost.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int ans1 = helper(0, cost);
        int ans2 = helper2(1, cost);

        return Math.min(ans1, ans2);
    }

    public int helper(int i, int cost[]) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp1[i] != -1) {
            return dp1[i];
        }

        int a = cost[i] + helper(i + 1, cost);
        int b = cost[i] + helper(i + 2, cost);

        return dp1[i] = Math.min(a, b);
    }

    public int helper2(int i, int cost[]) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp2[i] != -1) {
            return dp2[i];
        }

        int a = cost[i] + helper2(i + 1, cost);
        int b = cost[i] + helper2(i + 2, cost);

        return dp2[i] = Math.min(a, b);
    }
}