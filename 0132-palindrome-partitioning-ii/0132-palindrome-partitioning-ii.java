class Solution {
    Integer dp[][];

    public int minCut(String s) {
        int n = s.length();
        dp = new Integer[n][n];
        return helper(0, n - 1, s);
    }

    public int helper(int i, int j, String s) {

        if (i >= j || help(s.substring(i, j + 1))) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int op = Integer.MAX_VALUE;

        for (int ind = i; ind < j; ind++) {

            if (help(s.substring(i, ind + 1))) {

                int ans = 1 + helper(ind + 1, j, s);

                op = Math.min(op, ans);
            }
        }

        return dp[i][j] = op;
    }

    public boolean help(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}