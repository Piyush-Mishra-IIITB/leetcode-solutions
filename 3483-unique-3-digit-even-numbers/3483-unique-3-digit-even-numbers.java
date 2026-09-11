class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
        }

        int ans = 0;

        for (int a = 1; a <= 9; a++) {
            if (freq[a] == 0) continue;

            for (int b = 0; b <= 9; b++) {
                if (freq[b] == 0) continue;

                // Need another occurrence if a == b
                if (a == b && freq[a] < 2) continue;

                for (int c = 0; c <= 8; c += 2) {
                    if (freq[c] == 0) continue;

                    // Check whether enough occurrences exist
                    int needA = (a == b ? 1 : 0) + (a == c ? 1 : 0);
                    int needB = (b == c ? 1 : 0);

                    if (freq[a] >= 1 + needA &&
                        freq[b] >= 1 + needB &&
                        freq[c] >= 1) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}