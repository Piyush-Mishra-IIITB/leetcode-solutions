class Solution {

    Integer dp[][][];

    public int atMostNGivenDigitSet(String[] digits, int n) {

        String s = String.valueOf(n);

        dp = new Integer[s.length()][2][2];

        return helper(0, 1, 1, s, digits);
    }

    public int helper(int ind, int tight, int leadingZero, String s, String[] digits) {

        if (ind == s.length()) {
            return leadingZero == 1 ? 0 : 1;
        }

        if (dp[ind][tight][leadingZero] != null) {
            return dp[ind][tight][leadingZero];
        }

        int ans = 0;

        int up = (tight == 1) ? s.charAt(ind) - '0' : 9;

        // Skip current position (still haven't started)
        if (leadingZero == 1) {

            int newTight;

            if (tight == 1 && 0 == up)
                newTight = 1;
            else
                newTight = 0;

            ans += helper(ind + 1, newTight, 1, s, digits);
        }

        // Start / Continue the number
        for (String d : digits) {

            int digit = d.charAt(0) - '0';

            if (digit > up)
                continue;

            int newTight;

            if (tight == 1 && digit == up)
                newTight = 1;
            else
                newTight = 0;

            ans += helper(ind + 1, newTight, 0, s, digits);
        }

        return dp[ind][tight][leadingZero] = ans;
    }
}