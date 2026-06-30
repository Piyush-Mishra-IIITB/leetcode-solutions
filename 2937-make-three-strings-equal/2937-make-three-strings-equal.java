class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {

        int minLen = Math.min(s1.length(), Math.min(s2.length(), s3.length()));

        int prefixLen = 0;

        while (prefixLen < minLen) {
            char c = s1.charAt(prefixLen);
            if (s2.charAt(prefixLen) == c && s3.charAt(prefixLen) == c) {
                prefixLen++;
            } else {
                break;
            }
        }
        if (prefixLen == 0) {
            return -1;
        }
        return (s1.length() - prefixLen)
             + (s2.length() - prefixLen)
             + (s3.length() - prefixLen);
    }
}