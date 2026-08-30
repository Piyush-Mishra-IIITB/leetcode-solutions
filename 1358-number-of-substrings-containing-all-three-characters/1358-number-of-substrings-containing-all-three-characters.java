class Solution {

    public int numberOfSubstrings(String s) {

        int length = s.length();

        long total = ((long) length * (length + 1)) / 2;

        long op = total - helper(s);

        return (int) op;
    }

    public long helper(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        int low = 0;
        long ans = 0;

        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            hm.put(curr, hm.getOrDefault(curr, 0) + 1);

            while (hm.size() == 3) {

                char l = s.charAt(low);

                hm.put(l, hm.get(l) - 1);

                if (hm.get(l) == 0) {
                    hm.remove(l);
                }

                low++;
            }

            ans += i - low + 1;
        }

        return ans;
    }
}