class Solution {
    public int minDays(int[] arr, int m, int k) {
        if ((long) m * k > arr.length) {
            return -1;
        }

        int max = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(min, arr[i]);
        }

        int start = min;
        int end = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (helper(mid, arr, m, k)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public boolean helper(int days, int[] arr, int m, int k) {
        boolean vis[] = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= days) {
                vis[i] = true;
            } else {
                vis[i] = false;
            }
        }

        int count = 0;
        int i = 0;
        int j = k - 1;

        while (j < arr.length) {
            if (help(vis, i, j)) {
                count++;
                i = j + 1;
                j = j + k;
            } else {
                i++;
                j++;
            }
        }

        return count >= m;
    }

    public boolean help(boolean[] vis, int i, int j) {
        for (int k = i; k <= j; k++) {
            if (!vis[k]) {
                return false;
            }
        }
        return true;
    }
}