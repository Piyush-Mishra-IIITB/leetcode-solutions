class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (p.length() > s.length()) {
            return ans;
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            hm2.put(c, hm2.getOrDefault(c, 0) + 1);
        }

        if (hm.equals(hm2)) {
            ans.add(0);
        }
        int i = 0;
        int j = p.length();

        while (j < s.length()) {
            char left = s.charAt(i);
            hm2.put(left, hm2.get(left) - 1);

            if (hm2.get(left) == 0) {
                hm2.remove(left);
            }

            i++;
            char right = s.charAt(j);
            hm2.put(right, hm2.getOrDefault(right, 0) + 1);

            if (hm.equals(hm2)) {
                ans.add(i);
            }

            j++;
        }

        return ans;
    }
}