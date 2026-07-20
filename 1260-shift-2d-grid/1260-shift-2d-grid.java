class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ll.add(grid[i][j]);
            }
        }
        List<Integer> l = new ArrayList<>();
        int size = ll.size();
        k=k%size;
        for (int i = 0; i < size; i++) {
            l.add(ll.get((i - k + size) % size));
        }
        int len = grid[0].length;
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            a.add(l.get(i));
            if (a.size() == len) {
                ans.add(a);
                a = new ArrayList<>();
            }
        }
        return ans;
    }
}