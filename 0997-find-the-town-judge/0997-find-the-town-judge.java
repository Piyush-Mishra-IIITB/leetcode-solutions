class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] mat = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            mat[i][i] = 1;
        }
        for (int[] t : trust) {
            mat[t[0]][t[1]] = 1;
        }
        for (int j = 1; j <= n; j++) {
            boolean judge = true;
            for (int i = 1; i <= n; i++) {
                if (mat[i][j] == 0) {
                    judge = false;
                    break;
                }
            }
            if (judge) {
                for (int k = 1; k <= n; k++) {
                    if (k != j && mat[j][k] == 1) {
                        judge = false;
                        break;
                    }
                }
            }
            if (judge) return j;
        }
        return -1;
    }
}