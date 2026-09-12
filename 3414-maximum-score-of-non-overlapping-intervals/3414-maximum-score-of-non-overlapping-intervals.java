class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> {
            int x = Integer.compare(
                intervals.get(a).get(1),
                intervals.get(b).get(1)
            );

            if (x != 0) return x;

            return Integer.compare(a, b);
        });

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int start = intervals.get(order[i]).get(0);

            int l = 0;
            int r = i - 1;
            int ans = -1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (intervals.get(order[mid]).get(1) < start) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            prev[i] = ans + 1;
        }

        long[][] dp = new long[n + 1][5];
        int[][][] path = new int[n + 1][5][4];
        int[][] count = new int[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(path[i][j], -1);
            }
        }

        for (int i = 1; i <= n; i++) {
            int curr = order[i - 1];
            int weight = intervals.get(curr).get(2);

            for (int j = 1; j <= 4; j++) {

                dp[i][j] = dp[i - 1][j];
                count[i][j] = count[i - 1][j];
                path[i][j] = path[i - 1][j].clone();

                int p = prev[i - 1];

                long take = dp[p][j - 1] + weight;

                int[] candidate = new int[4];
                Arrays.fill(candidate, -1);

                int c = count[p][j - 1];

                for (int x = 0; x < c; x++) {
                    candidate[x] = path[p][j - 1][x];
                }

                candidate[c] = curr;
                c++;

                Arrays.sort(candidate, 0, c);

                if (take > dp[i][j] ||
                    (take == dp[i][j] &&
                     lexicographicallySmaller(candidate, c, path[i][j], count[i][j]))) {

                    dp[i][j] = take;
                    count[i][j] = c;
                    path[i][j] = candidate;
                }
            }
        }

        int c = count[n][4];

        int[] ans = new int[c];

        for (int i = 0; i < c; i++) {
            ans[i] = path[n][4][i];
        }

        return ans;
    }

    private boolean lexicographicallySmaller(
        int[] a, int ca,
        int[] b, int cb
    ) {
        int len = Math.min(ca, cb);

        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }

        return ca < cb;
    }
}