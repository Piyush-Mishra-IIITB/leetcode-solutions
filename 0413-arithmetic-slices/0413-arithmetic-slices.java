class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        int ans = 0;
        for (int i = 2; i < length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                int lengh = 3;
                int diff = nums[i] - nums[i - 1];
                int j;
                for (j = i + 1; j < length; j++) {
                    if (nums[j] - nums[j - 1] != diff) {
                        break;
                    }
                    lengh++;
                }
                ans += ((lengh - 2) * (lengh - 1)) / 2;
                i = j - 1; 
            }
        }
        return ans;
    }
}