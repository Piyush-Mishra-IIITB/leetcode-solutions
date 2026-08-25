class Solution {
    public long minCost(int[] nums, int[] cost) {

        int n = nums.length;

        long[][] arr = new long[n][2];

        long totalCost = 0;

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
            totalCost += cost[i];
        }

        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));
        long prefixCost = 0;
        long target = (totalCost + 1) / 2;

        long median = 0;

        for (int i = 0; i < n; i++) {
            prefixCost += arr[i][1];

            if (prefixCost >= target) {
                median = arr[i][0];
                break;
            }
        }
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.abs(arr[i][0] - median) * arr[i][1];
        }

        return ans;
    }
}