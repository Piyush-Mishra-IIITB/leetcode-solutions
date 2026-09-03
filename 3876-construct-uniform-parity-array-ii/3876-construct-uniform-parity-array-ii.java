
class Solution {

    public boolean uniformArray(int[] nums) {

        Arrays.sort(nums);

        int firstOdd = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                firstOdd = i;
                break;
            }
        }

        boolean allOdd = makeOdd(nums, firstOdd);
        boolean allEven = makeEven(nums, firstOdd);

        return allOdd || allEven;
    }
    public boolean makeOdd(int[] nums, int firstOdd) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                continue;
            }
            if (firstOdd == nums.length ||
                nums[firstOdd] >= nums[i]) {
                return false;
            }
        }

        return true;
    }
    public boolean makeEven(int[] nums, int firstOdd) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                continue;
            }
            if (firstOdd == nums.length ||
                nums[firstOdd] >= nums[i]) {
                return false;
            }
        }

        return true;
    }
}