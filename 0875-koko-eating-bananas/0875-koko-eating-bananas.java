class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        int start = 1;
        int end = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (helper(mid, arr, h)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    public boolean helper(int speed, int[] arr, int h) {
        long timeTaken = 0; 
        for (int i = 0; i < arr.length; i++) {
            timeTaken += (int) Math.ceil(arr[i] * 1.0 / speed);
        }

        return timeTaken <= h;
    }
}