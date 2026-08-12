class Solution {
    public List<Integer> partitionLabels(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        while (start < s.length()) {
            int end = hm.get(s.charAt(start));
            int i = start;
            while (i <= end) {
                end = Math.max(end, hm.get(s.charAt(i)));
                i++;
            }
            ans.add(end - start + 1);
            start = end + 1;
        }

        return ans;
    }
}