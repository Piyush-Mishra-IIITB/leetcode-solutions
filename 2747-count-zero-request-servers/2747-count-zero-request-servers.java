import java.util.*;

class Solution {

    int[] tree;

    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }

        int mid = start + (end - start) / 2;

        if (idx <= mid)
            update(2 * node, start, mid, idx, val);
        else
            update(2 * node + 1, mid + 1, end, idx, val);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    int query() {
        return tree[1];
    }

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);

        tree = new int[4 * (n + 1)];

        int[] count = new int[n + 1];
        int[] ans = new int[queries.length];

        int left = 0, right = 0;

        for (int[] curr : q) {

            int t = curr[0];

            while (right < logs.length && logs[right][1] <= t) {

                int id = logs[right][0];

                count[id]++;

                if (count[id] == 1)
                    update(1, 1, n, id, 1);

                right++;
            }

            while (left < right && logs[left][1] < t - x) {

                int id = logs[left][0];

                count[id]--;

                if (count[id] == 0)
                    update(1, 1, n, id, 0);

                left++;
            }

            ans[curr[1]] = n - query();
        }

        return ans;
    }
}