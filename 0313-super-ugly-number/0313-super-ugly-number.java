class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        int pointer[] = new int[primes.length];
        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE; 
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, (long) dp[pointer[j]] * primes[j]);
            }
            dp[i] = (int) min;
            for (int j = 0; j < primes.length; j++) {
                if ((long) dp[pointer[j]] * primes[j] == min) {
                    pointer[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}