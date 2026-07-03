class Solution {
    public boolean hasMatch(String s, String p) {

        int index = p.indexOf('*');

        String left = p.substring(0, index);
        String right = p.substring(index + 1);

        int ind = s.indexOf(left);

        if (ind == -1) return false;

        int ind2 = s.indexOf(right, ind + left.length());

        return ind2 != -1;
    }
}