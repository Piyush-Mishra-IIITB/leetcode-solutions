import java.util.*;

class Solution {

    public int carFleet(int target, int[] position, int[] speed) {

        int[][] arr = new int[position.length][2];

        // Store position and speed together
        for (int i = 0; i < position.length; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }

        // Sort by position
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // Calculate time needed by every car
        double[] time = new double[position.length];

        for (int i = 0; i < position.length; i++) {
            int dist = target - arr[i][0];
            int sp = arr[i][1];

            time[i] = (double) dist / sp;
        }

        int count = 0;
        double maxTime = 0;

        // Start from the car closest to target
        for (int i = time.length - 1; i >= 0; i--) {

            // This car cannot catch the fleet ahead
            if (time[i] > maxTime) {
                count++;
                maxTime = time[i];
            }
        }

        return count;
    }
}