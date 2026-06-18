class Solution {

    public long minimumCost(String source, String target,
                            char[] original, char[] changed, int[] cost) {

        long INF = (long) 1e18;
        long[][] dist = new long[26][26];

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = INF;
            }
            dist[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        for (int via = 0; via < 26; via++) {
            for (int i = 0; i < 26; i++) {
                if (dist[i][via] == INF) continue;

                for (int j = 0; j < 26; j++) {
                    if (dist[via][j] == INF) continue;
                    dist[i][j] =
                        Math.min(dist[i][j],
                                 dist[i][via] + dist[via][j]);
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';

            if (dist[u][v] == INF) {
                return -1;
            }

            ans += dist[u][v];
        }

        return ans;
    }
}