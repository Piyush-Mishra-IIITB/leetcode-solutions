import java.util.*;

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }
    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        parent.set(node, findParent(parent.get(node)));
        return parent.get(node);
    }

    public void unionByRank(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);

        if (pa == pb) return;

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
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet alice = new DisjointSet(n);
        DisjointSet bob = new DisjointSet(n);
        int removed = 0;
        for (int[] e : edges) {
            int type = e[0];
            int u = e[1];
            int v = e[2];
            if (type == 3) {
                if (alice.findParent(u) != alice.findParent(v)) {
                    alice.unionByRank(u, v);
                    bob.unionByRank(u, v);
                } else {
                    removed++;
                }
            }
        }
        for (int[] e : edges) {

            int type = e[0];
            int u = e[1];
            int v = e[2];
            if (type == 1) {
                if (alice.findParent(u) != alice.findParent(v)) {
                    alice.unionByRank(u, v);
                } else {
                    removed++;
                }
            }
        }
        for (int[] e : edges) {
            int type = e[0];
            int u = e[1];
            int v = e[2];
            if (type == 2) {
                if (bob.findParent(u) != bob.findParent(v)) {
                    bob.unionByRank(u, v);
                } else {
                    removed++;
                }
            }
        }
        int parentAlice = alice.findParent(1);
        for (int i = 2; i <= n; i++) {
            if (alice.findParent(i) != parentAlice) {
                return -1;
            }
        }
        int parentBob = bob.findParent(1);
        for (int i = 2; i <= n; i++) {
            if (bob.findParent(i) != parentBob) {
                return -1;
            }
        }
        return removed;
    }
}