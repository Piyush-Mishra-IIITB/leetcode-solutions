class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            first.putIfAbsent(nums[i], i);
            last.put(nums[i], i);
        }

        int degree = 0;
        for (int freq : count.values()) {
            degree = Math.max(degree, freq);
        }

        int ans = nums.length;

        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                ans = Math.min(ans, last.get(num) - first.get(num) + 1);
            }
        }

        return ans;
    }
}