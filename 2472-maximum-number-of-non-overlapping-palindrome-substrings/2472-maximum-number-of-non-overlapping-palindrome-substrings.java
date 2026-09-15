class Solution {
    public int maxPalindromes(String s, int k) {
        if (k == 1) {
            return s.length();
        }

        int count = 0;
        int start = 0;
        int end = k - 1;

        while (start < s.length() - k + 1 && end < s.length()) {

            if (isPalindrome(s, start, end)) {
                count++;
                start = end + 1;
                end = start + k - 1;

            } else if (end - start == k - 1) {
                end++;

            } else {
                start++;
            }
        }

        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}