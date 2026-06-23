import java.util.*;

class Solution {
    class Pair {
        int index;
        int steps;
        Pair(int index, int steps) {
            this.index = index;
            this.steps = steps;
        }
    }
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Pair> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.offer(new Pair(0, 0));
        vis[0] = true;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int idx = cur.index;
            int steps = cur.steps;
            if (idx == n - 1) {
                return steps;
            }
            if (idx + 1 < n && !vis[idx + 1]) {
                vis[idx + 1] = true;
                q.offer(new Pair(idx + 1, steps + 1));
            }
            if (idx - 1 >= 0 && !vis[idx - 1]) {
                vis[idx - 1] = true;
                q.offer(new Pair(idx - 1, steps + 1));
            }
            if (map.containsKey(arr[idx])) {
                for (int next : map.get(arr[idx])) {
                    if (!vis[next]) {
                        vis[next] = true;
                        q.offer(new Pair(next, steps + 1));
                    }
                }
                map.remove(arr[idx]);
            }
        }
        return -1;
    }
}