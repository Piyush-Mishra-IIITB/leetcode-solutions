class Solution {
    int k;
    int mod = 1_000_000_007;
    int n;
    int dp[][];
    public int numberOfSets(int n, int k) {
        int res = 0;
        this.k = k;
        this.n = n;
        dp = new int[n+1][k+1];
        return recurse(0, k);        
    }
    int recurse(int start, int currk) {
        if (currk == 0) return 1;
        if(dp[start][currk] > 0) return dp[start][currk];
        int ans = 0;
        int prev = 0;
        for (int i=start+1; i<=n-currk; i++){
            int w = i - start;
            int total = w * (w + 1) / 2;
            int current = total - prev;
            prev = total;
            int rhs = recurse(i, currk - 1);
            ans = (int)((ans + (long)rhs * current) % mod);
        }
        return dp[start][currk] = ans;
    }
}