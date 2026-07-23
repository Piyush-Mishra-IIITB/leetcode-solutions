
class Solution {
    Boolean dp[][];
    HashMap<Integer, Integer> hm = new HashMap<>();
    int stones[];
    public boolean canCross(int[] stones) {
        this.stones = stones;

        for (int i = 0; i < stones.length; i++) {
            hm.put(stones[i], i);
        }

        dp = new Boolean[stones.length][stones.length + 1];

        return helper(0, 0);
    }

    public boolean helper(int ind, int prev) {
        if (ind == stones.length - 1) {
            return true;
        }

        if (dp[ind][prev] != null) {
            return dp[ind][prev];
        }

        boolean a = false;

        int nextPos = stones[ind] + prev - 1;
        if (prev - 1 > 0 && hm.containsKey(nextPos)) {
            if (helper(hm.get(nextPos), prev - 1)) {
                a = true;
            }
        }

        nextPos = stones[ind] + prev;
        if (prev > 0 && hm.containsKey(nextPos)) {
            if (helper(hm.get(nextPos), prev)) {
                a = true;
            }
        }

        nextPos = stones[ind] + prev + 1;
        if (hm.containsKey(nextPos)) {
            if (helper(hm.get(nextPos), prev + 1)) {
                a = true;
            }
        }
        return dp[ind][prev] = a;
    }
}