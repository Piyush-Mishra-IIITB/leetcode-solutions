class Solution {
    public int threeSumClosest(int[] arr, int target) {

        Arrays.sort(arr);

        int close = arr[0] + arr[1] + arr[2];

        for (int i = 0; i < arr.length - 2; i++) {

            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                int sum = arr[i] + arr[start] + arr[end];
                if (Math.abs(sum - target) < Math.abs(close - target)) {
                    close = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        return close;
    }
}