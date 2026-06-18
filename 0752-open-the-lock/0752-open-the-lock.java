class Solution {
    public int openLock(String[] deadends, String target) {

        HashSet<String> dead = new HashSet<>();

        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        HashSet<String> vis = new HashSet<>();

        q.offer("0000");
        vis.add("0000");

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String curr = q.poll();

                if (curr.equals(target)) {
                    return steps;
                }
                for (String next : neighbors(curr)) {
                    if (!dead.contains(next) &&
                        !vis.contains(next)) {
                        vis.add(next);
                        q.offer(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private List<String> neighbors(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char original = arr[i];
            arr[i] = (char) ((original - '0' + 1) % 10 + '0');
            res.add(new String(arr));
            arr[i] = (char) ((original - '0' + 9) % 10 + '0');
            res.add(new String(arr));

            arr[i] = original;
        }

        return res;
    }
}