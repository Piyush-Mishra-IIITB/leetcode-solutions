class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int min= Integer.MAX_VALUE;
        for (int i = 0; i < time.length; i++) {
            min=Math.min(min,time[i]);
        }
        long start = 1;
        long end = (long) min * totalTrips;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (helper(mid, time, totalTrips)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public boolean helper(long curr, int arr[], int trips) {
        long currTrip = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > curr) {
                currTrip += 0;
            }
            if (arr[i] < curr) {
                currTrip += curr / arr[i];
            }
            if (arr[i] == curr) {
                currTrip += 1;
            }
        }
        return currTrip >= trips;
    }
}