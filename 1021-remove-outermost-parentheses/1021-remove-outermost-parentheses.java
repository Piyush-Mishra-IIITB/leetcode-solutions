class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                depth++;

                // If depth > 1, this is not the outermost '('
                if (depth > 1) {
                    ans.append(c);
                }

            } else {
                depth--;

                // If depth > 0, this is not the outermost ')'
                if (depth > 0) {
                    ans.append(c);
                }
            }
        }

        return ans.toString();
    }
}