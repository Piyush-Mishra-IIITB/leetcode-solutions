class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int mid = (n - 1) / 2;
        int[] arr1 = new int[mid + 1];
        int[] arr2 = new int[n - mid - 1];
        for (int i = 0; i <= mid; i++) {
            arr1[i] = nums[i];
        }
        int p = 0;
        for (int i = mid + 1; i < n; i++) {
            arr2[p++] = nums[i];
        }
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0)
                nums[k++] = arr1[i--];
            if (j >= 0)
                nums[k++] = arr2[j--];
        }
    }
}