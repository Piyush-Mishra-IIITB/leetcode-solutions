class Solution {

    Integer[][] dp;
    int OFFSET = 5000;

    public int tallestBillboard(int[] rods) {
        dp = new Integer[rods.length][10001];
        return Math.max(0, helper(0, 0, rods));
    }
    public int helper(int ind, int diff, int[] rods) {

        if (ind == rods.length) {
            return diff == 0 ? 0 : Integer.MIN_VALUE;
        }

        if (dp[ind][diff + OFFSET] != null){
             return dp[ind][diff + OFFSET];
        } 
        int skip = helper(ind + 1, diff, rods);

        int left = helper(ind + 1, diff + rods[ind], rods);
        if (left != Integer.MIN_VALUE){
            left += rods[ind];
        }
        int right = helper(ind + 1, diff - rods[ind], rods);
        return dp[ind][diff + OFFSET]=Math.max(skip, Math.max(left, right));
    }
}