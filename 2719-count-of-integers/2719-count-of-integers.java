class Solution {
    int MOD = 1000000007;
    Integer dp[][][][];

    public int count(String num1, String num2, int min_sum, int max_sum) {

        String num = subtractOne(num1);

        dp = new Integer[25][2][2][401];
        int big = helper(num2, 0, 1, 1, min_sum, max_sum, 0);

        dp = new Integer[25][2][2][401];
        int small = helper(num, 0, 1, 1, min_sum, max_sum, 0);

        return (big - small + MOD) % MOD;
    }

    public int helper(String s, int ind, int tide, int lz,
                      int min_sum, int max_sum, int curr_sum) {

        if (curr_sum > max_sum)
            return 0;

        if (ind == s.length()) {
            return (curr_sum >= min_sum && curr_sum <= max_sum) ? 1 : 0;
        }

        if (dp[ind][tide][lz][curr_sum] != null)
            return dp[ind][tide][lz][curr_sum];

        int ans = 0;

        int uw = (tide == 1) ? s.charAt(ind) - '0' : 9;

        for (int i = 0; i <= uw; i++) {

            int newTight = (tide == 1 && i == uw) ? 1 : 0;

            if (lz == 1 && i == 0) {
                ans = (ans + helper(s, ind + 1, newTight, 1,
                        min_sum, max_sum, curr_sum)) % MOD;
            } else {
                ans = (ans + helper(s, ind + 1, newTight, 0,
                        min_sum, max_sum, curr_sum + i)) % MOD;
            }
        }

        return dp[ind][tide][lz][curr_sum] = ans;
    }

    private String subtractOne(String s) {

        if (s.equals("0"))
            return "0";

        char[] arr = s.toCharArray();

        int i = arr.length - 1;

        while (i >= 0 && arr[i] == '0') {
            arr[i] = '9';
            i--;
        }

        arr[i]--;

        int start = 0;
        while (start < arr.length - 1 && arr[start] == '0')
            start++;

        return new String(arr, start, arr.length - start);
    }
}