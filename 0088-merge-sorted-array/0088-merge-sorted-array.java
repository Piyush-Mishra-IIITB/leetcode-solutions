class Solution {
    public void merge(int[] arr, int m, int[] arr2, int n) {

        int i = m - 1;        // last valid element of arr
        int j = n - 1;        // last element of arr2
        int k = m + n - 1;    // last position of arr

        while (i >= 0 && j >= 0) {

            if (arr[i] > arr2[j]) {
                arr[k] = arr[i];
                i--;
            } else {
                arr[k] = arr2[j];
                j--;
            }

            k--;
        }

        // If elements remain in arr2
        while (j >= 0) {
            arr[k] = arr2[j];
            j--;
            k--;
        }
    }
}