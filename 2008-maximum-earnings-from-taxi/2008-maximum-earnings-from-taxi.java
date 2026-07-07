class Solution {
    Long[] dp;
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[0] - b[0]); 
        dp = new Long[rides.length];

        return helper(0, rides);
    }

    public long helper(int ind, int[][] rides) {

        if (ind >= rides.length)
            return 0;

        if (dp[ind] != null)
            return dp[ind];

        long skip = helper(ind + 1, rides);

        int next = binarySearch(rides, ind);

        long earning = (long)(rides[ind][1] - rides[ind][0]) + rides[ind][2];

        long take = earning + helper(next, rides);

        return dp[ind] = Math.max(skip, take);
    }

    public int binarySearch(int[][] rides, int ind) {

        int start = ind + 1;
        int end = rides.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (rides[mid][0] >= rides[ind][1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}