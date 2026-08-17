class Solution {
    public long minArraySum(int[] arr) {

        HashSet<Integer> hs = new HashSet<>();

        for (int x : arr) {
            hs.add(x);
        }

        // If 1 exists, every element can become 1
        if (hs.contains(1)) {
            return arr.length;
        }

        long ans = 0;

        for (int i = 0; i < arr.length; i++) {

            int curr = arr[i];
            int best = curr;

            for (int j = 2; j * j <= curr; j++) {

                if (curr % j == 0) {

                    // j is a divisor
                    if (hs.contains(j)) {
                        best = Math.min(best, j);
                    }

                    // curr / j is also a divisor
                    int other = curr / j;

                    if (hs.contains(other)) {
                        best = Math.min(best, other);
                    }
                }
            }

            ans += best;
        }

        return ans;
    }
}