class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (hm.containsKey(curr)) {
                hm.get(curr).add(i);
            } else {
                List<Integer> ll = new ArrayList<>();
                ll.add(i);
                hm.put(curr, ll);
            }
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int prev = -1;
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                char curr = word.charAt(j);
                if (!hm.containsKey(curr)) {
                    flag = false;
                    break;
                }
                List<Integer> ll = hm.get(curr);
                int ind = upperBound(ll, prev);
                if (ind == ll.size()) {
                    flag = false;
                    break;
                }
                prev = ll.get(ind);
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
    public int upperBound(List<Integer> ll, int target) {
        int start = 0;
        int end = ll.size() - 1;
        int ans = ll.size();
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (ll.get(mid) > target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}