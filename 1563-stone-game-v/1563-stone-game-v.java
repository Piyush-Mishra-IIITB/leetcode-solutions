class Solution {
    Integer dp[][];
    int prefix[];

    public int stoneGameV(int[] arr) {
        int n = arr.length;

        dp = new Integer[n][n];
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        return helper(0, n - 1, arr);
    }

    public int helper(int left, int right, int arr[]) {

        if (left == right) {
            return 0;
        }

        if (dp[left][right] != null) {
            return dp[left][right];
        }

        int ans = Integer.MIN_VALUE;

        for (int k = left; k < right; k++) {

            int firstSum = getSum(left, k);
            int secondSum = getSum(k + 1, right);

            if (firstSum > secondSum) {

                ans = Math.max(
                    ans,
                    secondSum + helper(k + 1, right, arr)
                );

            } else if (firstSum < secondSum) {

                ans = Math.max(
                    ans,
                    firstSum + helper(left, k, arr)
                );

            } else {

                ans = Math.max(
                    ans,
                    Math.max(
                        firstSum + helper(left, k, arr),
                        secondSum + helper(k + 1, right, arr)
                    )
                );
            }
        }

        return dp[left][right] = ans;
    }
    public int getSum(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }
}