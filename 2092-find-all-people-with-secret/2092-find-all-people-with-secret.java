class Solution {
    
    public class pair {
        int v;
        int w;

        public pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        List<List<pair>> ll = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ll.add(new ArrayList<>());
        }

        for (int i = 0; i < meetings.length; i++) {
            int[] a = meetings[i];

            int u = a[0];
            int v = a[1];
            int w = a[2];

            ll.get(u).add(new pair(v, w));
            ll.get(v).add(new pair(u, w));
        }

        PriorityQueue<pair> pq =
                new PriorityQueue<>((a, b) -> a.w - b.w);

        pq.add(new pair(0, 0));
        pq.add(new pair(firstPerson, 0));

        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[0] = 0;
        dist[firstPerson] = 0;

        while (!pq.isEmpty()) {

            pair curr = pq.poll();

            int person = curr.v;
            int time = curr.w;

            if (time > dist[person]) {
                continue;
            }

            for (pair nbr : ll.get(person)) {

                int nextPerson = nbr.v;
                int meetTime = nbr.w;

                if (meetTime >= time &&
                    meetTime < dist[nextPerson]) {

                    dist[nextPerson] = meetTime;

                    pq.add(new pair(nextPerson, meetTime));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
}