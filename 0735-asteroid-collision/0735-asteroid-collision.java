import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            while (!st.isEmpty() && st.peek() > 0 && asteroid < 0) {

                if (st.peek() < -asteroid) {
                    // Stack asteroid explodes
                    st.pop();
                }
                else if (st.peek() == -asteroid) {
                    // Both explode
                    st.pop();
                    destroyed = true;
                    break;
                }
                else {
                    // Current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(asteroid);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = st.get(i);
        }

        return ans;
    }
}