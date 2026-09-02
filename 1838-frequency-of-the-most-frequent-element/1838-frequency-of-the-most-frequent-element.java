class Solution {

    public int maxFrequency(int[] arr, int k) {

        Arrays.sort(arr);

        int n = arr.length;

        // Step 1: Build prefix sum
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        // Step 2: Binary search on answer
        int low = 1;
        int high = n;
        int ans = 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(mid, arr, prefix, k)) {

                // mid frequency is possible
                ans = mid;

                // Try for a bigger frequency
                low = mid + 1;

            } else {

                // mid frequency is not possible
                high = mid - 1;
            }
        }

        return ans;
    }


    private boolean canMake(
        int len,
        int[] arr,
        long[] prefix,
        int k
    ) {

        // Check every window of size len
        for (int right = len - 1; right < arr.length; right++) {

            int left = right - len + 1;

            // O(1) window sum using prefix sum
            long sum = prefix[right + 1] - prefix[left];

            // Operations needed
            long cost = (long) arr[right] * len - sum;

            if (cost <= k) {
                return true;
            }
        }

        return false;
    }
}