class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long curr = 1;
        ans.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            curr = curr * (rowIndex - i + 1) / i;
            ans.add((int)curr);
        }
        return ans;
    }
}