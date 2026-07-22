class Solution {
    public int minOperations(int[] arr, int x) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int target = sum - x;
        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return arr.length;
        }
        int currSum = 0;
        int low = 0;
        int maxLen = -1;
        for (int high = 0; high < arr.length; high++) {
            currSum += arr[high];
            while (currSum > target) {
                currSum -= arr[low];
                low++;
            }
            if (currSum == target) {
                maxLen = Math.max(maxLen, high - low + 1);
            }
        }
        return maxLen == -1 ? -1 : arr.length - maxLen;
    }
}
    