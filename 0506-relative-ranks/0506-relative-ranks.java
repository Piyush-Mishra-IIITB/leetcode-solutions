class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            int rank = helper(score, score[i]);

            if (rank == 1)
                ans[i] = "Gold Medal";
            else if (rank == 2)
                ans[i] = "Silver Medal";
            else if (rank == 3)
                ans[i] = "Bronze Medal";
            else
                ans[i] = String.valueOf(rank);
        }

        return ans;
    }

    public int helper(int[] arr, int val) {
        int rank = 1;

        for (int x : arr) {
            if (x > val)
                rank++;
        }

        return rank;
    }
}