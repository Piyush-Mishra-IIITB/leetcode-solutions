class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
            max = Math.max(max, candies[i]);
        }
        if (sum < k) {
            return 0;
        }

        int start = 1;
        int end = max;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (helper(mid, candies, k)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
    public boolean helper(int candy, int arr[], long k) {
        long child = 0;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            if (curr >= candy) {
                child += curr / candy;
            }
        }
        return child >= k;
    }
}