class Solution {

    class Node {
        Node[] links = new Node[26];
        boolean isEnd = false;

        boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }

        void put(char c, Node node) {
            links[c - 'a'] = node;
        }

        Node get(char c) {
            return links[c - 'a'];
        }

        void setEnd() {
            isEnd = true;
        }
    }

    Node root = new Node();

    void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!node.containsKey(c)) {
                node.put(c, new Node());
            }

            node = node.get(c);
        }

        node.setEnd();
    }

    boolean isValid(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.get(c);
            if (node == null || !node.isEnd) {
                return false;
            }
        }

        return true;
    }
    public String longestWord(String[] words) {
        for (String word : words) {
            insert(word);
        }
        String answer = "";
        for (String word : words) {
            if (isValid(word)) {
                if (word.length() > answer.length()) {
                    answer = word;
                }
                else if (word.length() == answer.length()
                        && word.compareTo(answer) < 0) {
                    answer = word;
                }
            }
        }

        return answer;
    }
}