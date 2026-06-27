class Solution {
    Integer[][] dp;

    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        dp = new Integer[n][m];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += helper(i, j, matrix, n, m);
            }
        }

        return ans;
    }

    public int helper(int i, int j, int[][] matrix, int n, int m) {

        if (i >= n || j >= m)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        if (matrix[i][j] == 0)
            return dp[i][j] = 0;

        int down = helper(i + 1, j, matrix, n, m);
        int right = helper(i, j + 1, matrix, n, m);
        int diagonal = helper(i + 1, j + 1, matrix, n, m);

        return dp[i][j] = 1 + Math.min(down, Math.min(right, diagonal));
    }
}