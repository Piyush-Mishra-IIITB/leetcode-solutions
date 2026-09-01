class Solution {
    public List<Integer> goodDaysToRobBank(int[] arr, int k) {

        int n = arr.length;

        int[] small = new int[n];
        int[] great = new int[n];
        for (int i = 1; i < n; i++) {

            if (arr[i] <= arr[i - 1]) {
                small[i] = small[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {

            if (arr[i] <= arr[i + 1]) {
                great[i] = great[i + 1] + 1;
            }
        }

        List<Integer> ll = new ArrayList<>();

        for (int i = k; i < n - k; i++) {

            if (small[i] >= k && great[i] >= k) {
                ll.add(i);
            }
        }

        return ll;
    }
}