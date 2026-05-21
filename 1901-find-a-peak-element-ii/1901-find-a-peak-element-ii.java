class Solution {

    public int[] findPeakGrid(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                int curr = arr[i][j];

                boolean up =
                    (i == 0) || (curr > arr[i-1][j]);

                boolean down =
                    (i == rows-1) || (curr > arr[i+1][j]);

                boolean left =
                    (j == 0) || (curr > arr[i][j-1]);

                boolean right =
                    (j == cols-1) || (curr > arr[i][j+1]);

                if(up && down && left && right) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}