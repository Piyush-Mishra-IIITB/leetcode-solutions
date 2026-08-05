import java.util.*;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums[0] == 0) {
            int sum = 0;
            for (int x : nums) sum += x;
            return sum;
        }
        if (nums[0] > 0) {
            int sum = 0;
            for (int x : nums) sum += x;

            if (k % 2 == 0)
                return sum;
            else
                return sum - 2 * nums[0];
        }
        int neg = 0;
        boolean hasZero = false;

        for (int x : nums) {
            if (x < 0) neg++;
            if (x == 0) hasZero = true;
        }
        if (k < neg) {
            for (int i = 0; i < k; i++) {
                nums[i] = -nums[i];
            }

            int sum = 0;
            for (int x : nums) sum += x;
            return sum;
        }
        for (int i = 0; i < neg; i++) {
            nums[i] = -nums[i];
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int x : nums) {
            sum += x;
            min = Math.min(min, x);
        }
        int rem = k - neg;
        if (hasZero)
            return sum;
        if (rem % 2 == 0)
            return sum;

        return sum - 2 * min;
    }
}