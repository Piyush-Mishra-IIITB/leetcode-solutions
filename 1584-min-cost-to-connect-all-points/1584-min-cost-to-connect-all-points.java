class Solution {

    class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

        boolean[] vis = new boolean[n];

        pq.offer(new Pair(0, 0));

        int cost = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {

            Pair curr = pq.poll();

            if (vis[curr.node]) {
                continue;
            }

            vis[curr.node] = true;
            cost += curr.cost;
            count++;

            for (int next = 0; next < n; next++) {

                if (!vis[next]) {

                    int dist =
                            Math.abs(points[curr.node][0] - points[next][0]) +
                            Math.abs(points[curr.node][1] - points[next][1]);

                    pq.offer(new Pair(next, dist));
                }
            }
        }

        return cost;
    }
}