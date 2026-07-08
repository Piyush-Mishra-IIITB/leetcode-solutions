class Solution {
    static final int MOD = 1000000007;
    Integer dp[][];
    int[][] freq;

    public int numWays(String[] words, String target) {

        int m = words[0].length();

        dp = new Integer[m + 1][target.length() + 1];
        freq = new int[m][26];
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                freq[i][word.charAt(i) - 'a']++;
            }
        }

        return helper(0, 0, target);
    }

    public int helper(int i, int j, String target) {

        if (j == target.length()) {
            return 1;
        }

        if (i == freq.length) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        long skip = helper(i + 1, j, target);

        long pick = 0;

        int cnt = freq[i][target.charAt(j) - 'a'];

        if (cnt > 0) {
            pick = (cnt * 1L * helper(i + 1, j + 1, target)) % MOD;
        }

        return dp[i][j] = (int) ((skip + pick) % MOD);
    }
}