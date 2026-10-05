class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0;
        Stack<Object> ss = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr == '(') {
                ss.push('(');
            } else {

                int val = 0;
                while (!ss.isEmpty() && ss.peek() instanceof Integer) {
                    val += (Integer) ss.pop();
                }
                ss.pop();

              
                if (val == 0) {
                    val = 1;
                } else {
                    val *= 2;
                }

                if (ss.isEmpty()) {
                    ans += val;
                } else {
                    ss.push(val);
                }
            }
        }

        return ans;
    }
}