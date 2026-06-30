class Solution {
    public int countGoodSubstrings(String s) {

        if (s.length() < 3) {
            return 0;
        }
        int i = 0;
        int j = 3;
        int ans = 0;
        while (j <= s.length()) {
            String ss = s.substring(i, j);
            if (ss.charAt(0) != ss.charAt(1) &&
                ss.charAt(1) != ss.charAt(2) &&
                ss.charAt(0) != ss.charAt(2)) {
                ans++;
            }
            i++;
            j++;
        }
        return ans;
    }
}