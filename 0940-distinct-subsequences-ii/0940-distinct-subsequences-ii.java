class Solution {
    public int distinctSubseqII(String s) {
        long[] last = new long[26];
        long total = 1; 
        long MOD = 1000000007;

        for (char c : s.toCharArray()) {
            int x = c - 'a';

            long newTotal = (2 * total - last[x] + MOD) % MOD;

            last[x] = total;
            total = newTotal;
        }

        return (int)((total - 1 + MOD) % MOD);
    }
}