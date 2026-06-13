class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        HashMap<Integer,Character> hm = new HashMap<>();
        char var = 'z';
        for(int i = 0; i < 26; i++){
            hm.put(i, var);
            var--;
        }

        HashMap<Character,Integer> hm2 = new HashMap<>();
        char var2 = 'a';
        for(int i = 0; i < 26; i++){
            hm2.put(var2, weights[i]);
            var2++;
        }

        StringBuilder anss = new StringBuilder();

        for(int i = 0; i < words.length; i++){
            String ss = words[i];
            int ans = 0;

            for(int j = 0; j < ss.length(); j++){
                char c = ss.charAt(j);
                ans += hm2.get(c);
            }

            ans %= 26;
            char curr = hm.get(ans);
            anss.append(curr);
        }

        return anss.toString();
    }
}