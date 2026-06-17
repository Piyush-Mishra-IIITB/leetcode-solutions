class Solution {
    public String largestGoodInteger(String num) {
        int i = 0;
        int j = 2;
        StringBuilder sb = new StringBuilder();
        while (j < num.length()) {
            if (helper(i, j, num)) {
                sb.append(num.charAt(i));
            }
            i++;
            j++;
        }
        if (sb.length() == 0) {
            return "";
        }
        
        int ans = 0;
        for (int p = 0; p < sb.length(); p++) {
            ans = Math.max(ans, sb.charAt(p) - '0');
        }
        StringBuilder anss = new StringBuilder();
        for (int p = 0; p < 3; p++) {
            anss.append((char)(ans + '0'));
        }
        return anss.toString();
    }
    
    public boolean helper(int i, int j, String ss) {
        char c = ss.charAt(i);
        for (int k = i + 1; k <= j; k++) {
            if (ss.charAt(k) != c) {
                return false;
            }
        }
        return true;
    }
}
