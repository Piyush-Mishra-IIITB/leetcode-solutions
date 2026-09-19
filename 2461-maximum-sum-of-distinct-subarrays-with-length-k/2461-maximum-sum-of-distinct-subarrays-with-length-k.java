class Solution {
    public long maximumSubarraySum(int[] arr, int k) {

        int low = 0;
        long ans = 0;
        long sum = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int high = 0; high < arr.length; high++) {

            sum += arr[high];

            int curr = arr[high];

            hm.put(curr, hm.getOrDefault(curr, 0) + 1);

            // Maintain window size <= k
            while (high - low + 1 > k) {

                sum -= arr[low];

                int val = hm.get(arr[low]);

                if (val == 1) {
                    hm.remove(arr[low]);
                } else {
                    hm.put(arr[low], val - 1);
                }

                low++;
            }

            // Exactly k elements and all are distinct
            if (high - low + 1 == k && hm.size() == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}