import java.util.*;

class Solution {

    class Pair {
        String node;
        double wt;

        Pair(String node, double wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public double[] calcEquation(List<List<String>> equations,double[] values,List<List<String>> queries) {

        Map<String, List<Pair>> adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(new Pair(v, val));
            adj.get(v).add(new Pair(u, 1.0 / val));
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            if (!adj.containsKey(src) || !adj.containsKey(dest)) {
                ans[i] = -1.0;
                continue;
            }
            if (src.equals(dest)) {
                ans[i] = 1.0;
                continue;
            }
            Set<String> vis = new HashSet<>();
            ans[i] = dfs(src, dest, adj, vis, 1.0);
        }
        return ans;
    }

    public double dfs(String src,String dest,Map<String, List<Pair>> adj,Set<String> vis,double product) {
        if (src.equals(dest)) {
            return product;}
        vis.add(src);
        for (Pair p : adj.get(src)) {
            if (!vis.contains(p.node)) {
                double ans = dfs(p.node,dest,adj,vis,product * p.wt);
                if (ans != -1.0) {
                    return ans;
                }
            }
        }
        return -1.0;
    }
}