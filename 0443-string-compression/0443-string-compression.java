class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int counter = 1;
        List<Character> ll = new ArrayList<>();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                ll.add(chars[i - 1]);
                if (counter > 1) {
                    for (char c : String.valueOf(counter).toCharArray()) {
                        ll.add(c);
                    }
                }
                counter = 1;
            } else {
                counter++;
            }
        }
        ll.add(chars[chars.length - 1]);
        if (counter > 1) {
            for (char c : String.valueOf(counter).toCharArray()) {
                ll.add(c);
            }
        }
        for (int i = 0; i < ll.size(); i++) {
            chars[i] = ll.get(i);
        }
        return ll.size();
    }
}