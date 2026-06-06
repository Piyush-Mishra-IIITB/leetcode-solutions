class Solution {
    public int islandPerimeter(int[][] grid) {
        int land = 0;
        int shared = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    land++;

                    if (i > 0 && grid[i - 1][j] == 1) shared++;
                    if (j > 0 && grid[i][j - 1] == 1) shared++;
                }
            }
        }

        return 4 * land - 2 * shared;
    }
}