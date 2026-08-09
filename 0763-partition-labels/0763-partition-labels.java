class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> largest = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            largest.put(curr, i);
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int last = largest.get(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, largest.get(s.charAt(i)));
            if (i == last) {
                ans.add(i - start + 1);
                start = i + 1;
                if (start < s.length()) {
                    last = largest.get(s.charAt(start));
                }
            }
        }
        return ans;
    }
}