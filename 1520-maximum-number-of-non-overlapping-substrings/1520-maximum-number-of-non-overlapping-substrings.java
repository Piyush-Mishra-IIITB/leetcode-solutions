class Solution {

    public class pair {
        int row;
        int col;

        public pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<String> maxNumOfSubstrings(String s) {

        HashMap<Character, pair> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (hm.containsKey(curr)) {
                pair p = hm.get(curr);
                p.col = i;
            } else {
                hm.put(curr, new pair(i, i));
            }
        }

        List<List<Integer>> intervals = new ArrayList<>();
        for (char c : hm.keySet()) {

            pair p = hm.get(c);

            int l = p.row;
            int r = p.col;

            boolean valid = true;

            for (int i = l; i <= r; i++) {

                char curr = s.charAt(i);
                pair currPair = hm.get(curr);
                if (currPair.row < l) {
                    valid = false;
                    break;
                }

                r = Math.max(r, currPair.col);
            }

            if (valid) {
                intervals.add(Arrays.asList(l, r));
            }
        }
        Collections.sort(intervals, (a, b) -> a.get(1) - b.get(1));

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        for (List<Integer> interval : intervals) {

            int l = interval.get(0);
            int r = interval.get(1);

            if (l > prevEnd) {
                ans.add(s.substring(l, r + 1));
                prevEnd = r;
            }
        }

        return ans;
    }
}