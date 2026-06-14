class DisjointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }
    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int p = findParent(parent.get(node));
        parent.set(node, p);
        return p;
    }
    public void unionByRank(int a, int b) {

        int pa = findParent(a);
        int pb = findParent(b);

        if (pa == pb) {
            return;
        }

        if (rank.get(pa) > rank.get(pb)) {
            parent.set(pb, pa);
        } else if (rank.get(pa) < rank.get(pb)) {
            parent.set(pa, pb);
        } else {
            parent.set(pb, pa);
            rank.set(pa, rank.get(pa) + 1);
        }
    }
}

class Solution {

    public boolean[] distanceLimitedPathsExist(int n,int[][] edgeList,int[][] queries) {

        DisjointSet ds = new DisjointSet(n);

        int[][] q = new int[queries.length][4];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = queries[i][2];
            q[i][3] = i; 
        }
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
        Arrays.sort(q, (a, b) -> Integer.compare(a[2], b[2]));
        boolean[] ans = new boolean[queries.length];
        int edgePtr = 0;
        for (int i = 0; i < q.length; i++) {
            int u = q[i][0];
            int v = q[i][1];
            int limit = q[i][2];
            int idx = q[i][3];
            while (edgePtr < edgeList.length &&edgeList[edgePtr][2] < limit) {
                ds.unionByRank(edgeList[edgePtr][0],edgeList[edgePtr][1]
                );
                edgePtr++;
            }
            ans[idx] =ds.findParent(u) == ds.findParent(v);
        }
        return ans;
    }
}