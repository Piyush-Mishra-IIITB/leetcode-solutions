class Solution {

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !vis[0][j]) {
                dfs(0, j, board, vis);
            }
            if (board[n - 1][j] == 'O' && !vis[n - 1][j]) {
                dfs(n - 1, j, board, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                dfs(i, 0, board, vis);
            }
            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                dfs(i, m - 1, board, vis);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board, boolean[][] vis) {
        int n = board.length;
        int m = board[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m ||
            board[r][c] == 'X' || vis[r][c]) {
            return;
        }

        vis[r][c] = true;

        dfs(r + 1, c, board, vis);
        dfs(r - 1, c, board, vis);
        dfs(r, c + 1, board, vis);
        dfs(r, c - 1, board, vis);
    }
}
