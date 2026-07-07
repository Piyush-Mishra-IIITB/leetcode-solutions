class Solution {
    Integer[][] dp;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        dp = new Integer[events.length][k + 1];
        return helper(0, events, k);
    }
    public int helper(int ind, int[][] arr, int k) {
        if (ind >= arr.length || k == 0) {
            return 0;
        }
        if (dp[ind][k] != null) {
            return dp[ind][k];
        }
        int skip = helper(ind + 1, arr, k);
        int nextIndex = BinaryS(arr, ind);
        int take = arr[ind][2] + helper(nextIndex, arr, k - 1);
        return dp[ind][k] = Math.max(skip, take);
    }
    public int BinaryS(int[][] arr, int ind) {
        int start = ind + 1;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid][0] > arr[ind][1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}