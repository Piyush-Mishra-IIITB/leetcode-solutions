class Solution {
    public boolean validateStackSequences(int[] push, int[] pop) {

        Stack<Integer> ss = new Stack<>();

        int i = 0;
        int j = 0;

        while(i < push.length && j < pop.length) {

            ss.push(push[i]);

            while(!ss.isEmpty() && ss.peek() == pop[j]) {
                ss.pop();
                j++;
            }

            i++;
        }

        return ss.isEmpty();
    }
}