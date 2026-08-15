class Solution {

    List<String> ans = new ArrayList<>();

    public class Node {
        Node links[] = new Node[26];
        boolean flag = false;

        boolean containsKey(char curr) {
            return links[curr - 'a'] != null;
        }

        void put(char curr, Node node) {
            links[curr - 'a'] = node;
        }

        Node get(char curr) {
            return links[curr - 'a'];
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag;
        }
    }

    Node root;

    public Solution() {
        root = new Node();
    }

    public void put(String s) {

        Node node = root;

        for(int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if(!node.containsKey(curr)) {
                node.put(curr, new Node());
            }

            node = node.get(curr);
        }

        node.setEnd();
    }

    public void helper(StringBuilder sb, Node node) {

        if(ans.size() == 3)
            return;
        if(node.isEnd()) {
            ans.add(sb.toString());

            if(ans.size() == 3)
                return;
        }
        for(char curr = 'a'; curr <= 'z'; curr++) {

            if(!node.containsKey(curr))
                continue;

            Node next = node.get(curr);

            sb.append(curr);

            helper(sb, next);

            sb.deleteCharAt(sb.length() - 1);

            if(ans.size() == 3)
                return;
        }
    }

    public List<List<String>> suggestedProducts(
        String[] products,
        String searchWord) {
        for(String s : products) {
            put(s);
        }

        List<List<String>> result = new ArrayList<>();

        Node node = root;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < searchWord.length(); i++) {

            char curr = searchWord.charAt(i);

            sb.append(curr);

            if(!node.containsKey(curr)) {
                while(i < searchWord.length()) {
                    result.add(new ArrayList<>());
                    i++;
                }

                break;
            }

            node = node.get(curr);

            ans = new ArrayList<>();

            helper(sb, node);

            result.add(new ArrayList<>(ans));
        }

        return result;
    }
}