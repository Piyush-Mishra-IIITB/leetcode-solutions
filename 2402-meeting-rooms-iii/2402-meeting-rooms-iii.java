class Solution {
    public class pai {
        int i;
        int c;

        public pai(int i, int c) {
            this.i = i;
            this.c = c;
        }
    }

    public class pair {
        int which;
        long time;
        int count;

        public pair(int which, long time, int count) {
            this.which = which;
            this.time = time;
            this.count = count;
        }
    }

    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Busy rooms:
        // minimum time
        // if same time -> minimum room number
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.time != b.time) {
                    return Long.compare(a.time, b.time);
                }
                return Integer.compare(a.which, b.which);
            }
        );

        // Free rooms:
        // minimum room number
        PriorityQueue<pai> pq2 =
            new PriorityQueue<>((a, b) -> a.i - b.i);

        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            pq2.add(new pai(i, 0));
        }

        int ind = 0;

        while (ind < meetings.length) {

            int currS = meetings[ind][0];
            int currEnd = meetings[ind][1];

            // Move every finished room to free PQ
            while (!pq.isEmpty() && pq.peek().time <= currS) {

                pair p = pq.poll();

                pq2.add(new pai(p.which, p.count));
            }

            // Free room available
            if (!pq2.isEmpty()) {

                pai p = pq2.poll();

                count[p.i]++;

                pq.add(
                    new pair(
                        p.i,
                        currEnd,
                        count[p.i]
                    )
                );
            }

            // All rooms busy
            else {

                pair p = pq.poll();

                int duration = currEnd - currS;

                count[p.which]++;

                pq.add(
                    new pair(
                        p.which,
                        p.time + duration,
                        count[p.which]
                    )
                );
            }

            ind++;
        }

        // Find maximum count
        // Tie -> smallest room number
        int ans = 0;

        for (int i = 1; i < n; i++) {

            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}