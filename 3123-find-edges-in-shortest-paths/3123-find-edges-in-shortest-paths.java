class Solution {

    class Pair {
        int node;
        long wt;

        public Pair(int node, long wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    private static final long INF = (long) 1e18;

    public boolean[] findAnswer(int n, int[][] edges) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        long[] start = new long[n];
        long[] end = new long[n];

        dijkstra(adj, 0, start);
        dijkstra(adj, n - 1, end);

        long shortest = start[n - 1];

        boolean[] ans = new boolean[edges.length];

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            boolean ok = false;

            if (start[u] != INF &&
                end[v] != INF &&
                start[u] + w + end[v] == shortest) {
                ok = true;
            }

            if (start[v] != INF &&
                end[u] != INF &&
                start[v] + w + end[u] == shortest) {
                ok = true;
            }

            ans[i] = ok;
        }

        return ans;
    }

    public void dijkstra(List<List<Pair>> adj, int source, long[] dist) {

        Arrays.fill(dist, INF);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.wt, b.wt));

        dist[source] = 0;
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {

            Pair p = pq.poll();

            int u = p.node;
            long d = p.wt;

            if (d > dist[u]) {
                continue;
            }

            for (Pair curr : adj.get(u)) {

                int v = curr.node;
                long wt = curr.wt;

                if (d + wt < dist[v]) {

                    dist[v] = d + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
    }
}