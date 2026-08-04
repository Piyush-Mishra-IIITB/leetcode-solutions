class Solution {
    HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression);
    }
    public List<Integer> helper(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = helper(s.substring(0, i));
                List<Integer> right = helper(s.substring(i + 1));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        if (c == '+') {
                            ans.add(left.get(j) + right.get(k));
                        } else if (c == '-') {
                            ans.add(left.get(j) - right.get(k));
                        } else {
                            ans.add(left.get(j) * right.get(k));
                        }
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.parseInt(s));
        }
        map.put(s, ans);
        return ans;
    }
}