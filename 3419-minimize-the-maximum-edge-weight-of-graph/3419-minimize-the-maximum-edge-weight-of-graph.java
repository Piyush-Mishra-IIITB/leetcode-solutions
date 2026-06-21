class Solution {

    public int minMaxWeight(int n, int[][] edges, int threshold) {

        int maxEdge = 0;
        for (int[] e : edges) {
            maxEdge = Math.max(maxEdge, e[2]);
        }

        int low = 0, high = maxEdge;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(n, edges, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int n, int[][] edges, int maxWeight) {

        List<Integer>[] rev = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            rev[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            if (w <= maxWeight) {
                rev[v].add(u);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : rev[cur]) {
                if (!vis[nxt]) {
                    vis[nxt] = true;
                    q.offer(nxt);
                }
            }
        }

        for (boolean x : vis) {
            if (!x) return false;
        }

        return true;
    }
}