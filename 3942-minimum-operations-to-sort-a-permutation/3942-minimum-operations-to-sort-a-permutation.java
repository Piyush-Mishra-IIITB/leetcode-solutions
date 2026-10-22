class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int k = 0; k < n; k++) {
            boolean ok = true;

            for (int i = 0; i < n; i++) {
                if (nums[(i + k) % n] != i) {
                    ok = false;
                    break;
                }
            }

            if (ok) ans = Math.min(ans, Math.min(k, n - k + 2));

            ok = true;
            for (int i = 0; i < n; i++) {
                if (nums[n - 1 - ((i + k) % n)] != i) {
                    ok = false;
                    break;
                }
            }

            if (ok) ans = Math.min(ans, 1 + Math.min(k, n - k));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}