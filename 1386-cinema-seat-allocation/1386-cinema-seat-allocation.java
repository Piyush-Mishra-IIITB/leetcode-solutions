class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int[] a : reservedSeats) {
            int u = a[0];
            int v = a[1];

            hm.putIfAbsent(u, new ArrayList<>());
            hm.get(u).add(v);
        }

        int count = (n - hm.size()) * 2;

        for (List<Integer> ll : hm.values()) {

            boolean first = true;
            boolean second = true;
            boolean third = true;

            for (int j = 2; j <= 5; j++) {
                if (ll.contains(j)) {
                    first = false;
                    break;
                }
            }

            for (int j = 4; j <= 7; j++) {
                if (ll.contains(j)) {
                    second = false;
                    break;
                }
            }

            for (int j = 6; j <= 9; j++) {
                if (ll.contains(j)) {
                    third = false;
                    break;
                }
            }

            if (first && third) {
                count += 2;
            } else if (first || second || third) {
                count += 1;
            }
        }

        return count;
    }
}