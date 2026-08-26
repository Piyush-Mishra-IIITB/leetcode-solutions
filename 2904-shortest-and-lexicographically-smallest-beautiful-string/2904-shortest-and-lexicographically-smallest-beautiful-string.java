class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int count = 0;
        int low = 0;
        int lower = 0;
        int ans = Integer.MAX_VALUE;

        for (int high = 0; high < s.length(); high++) {

            if (s.charAt(high) == '1') {
                count++;
            }

            while (count >= k) {

                if (count == k) {
                    int len = high - low + 1;

                    if (len < ans ||
                        (len == ans &&
                         s.substring(low, high + 1)
                          .compareTo(s.substring(lower, lower + ans)) < 0)) {

                        ans = len;
                        lower = low;
                    }
                }

                if (s.charAt(low) == '1') {
                    count--;
                }

                low++;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(lower, lower + ans);
    }
}