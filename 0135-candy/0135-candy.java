import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int length = ratings.length;

        for (int i = 0; i < length; i++) {
            hm.put(i, 1);
        }

        int candies = length;

        // Left to Right
        for (int i = 0; i < length; i++) {

            int prev = Integer.MIN_VALUE;
            if (i > 0) prev = ratings[i - 1];

            int forw = Integer.MIN_VALUE;
            if (i != length - 1) forw = ratings[i + 1];

            int curr = ratings[i];

            int newValue = hm.get(i);

            if (curr > prev && curr > forw) {
                int a = 0;
                if (i > 0) a = hm.get(i - 1);

                int b = 0;
                if (i != length - 1) b = hm.get(i + 1);

                newValue = Math.max(newValue, Math.max(a, b) + 1);
            } else if (curr > prev && curr <= forw) {
                int a = 0;
                if (i > 0) a = hm.get(i - 1);

                newValue = Math.max(newValue, a + 1);
            } else if (curr <= prev && curr > forw) {
                int a = 0;
                if (i != length - 1) a = hm.get(i + 1);

                newValue = Math.max(newValue, a + 1);
            }

            candies -= hm.get(i);
            hm.put(i, newValue);
            candies += newValue;
        }

        // Right to Left
        for (int i = length - 1; i >= 0; i--) {

            int prev = Integer.MIN_VALUE;
            if (i > 0) prev = ratings[i - 1];

            int forw = Integer.MIN_VALUE;
            if (i != length - 1) forw = ratings[i + 1];

            int curr = ratings[i];

            int newValue = hm.get(i);

            if (curr > prev && curr > forw) {
                int a = 0;
                if (i > 0) a = hm.get(i - 1);

                int b = 0;
                if (i != length - 1) b = hm.get(i + 1);

                newValue = Math.max(newValue, Math.max(a, b) + 1);
            } else if (curr > prev && curr <= forw) {
                int a = 0;
                if (i > 0) a = hm.get(i - 1);

                newValue = Math.max(newValue, a + 1);
            } else if (curr <= prev && curr > forw) {
                int a = 0;
                if (i != length - 1) a = hm.get(i + 1);
                newValue = Math.max(newValue, a + 1);
            }
            candies -= hm.get(i);
            hm.put(i, newValue);
            candies += newValue;
        }
        return candies;
    }
}