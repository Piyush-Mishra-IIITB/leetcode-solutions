class Solution {
    
    public int calculate(String s) {

        List<String> tokens = new ArrayList<>();
        int num = 0;

        // Step 1: Convert String into tokens
        for (int i = 0; i < s.length(); i++) {

            char curr = s.charAt(i);

            if (curr == ' ') {
                continue;
            }

            if (Character.isDigit(curr)) {
                num = num * 10 + (curr - '0');
            } 
            else {
                tokens.add(Integer.toString(num));
                tokens.add(Character.toString(curr));
                num = 0;
            }
        }

        // Add last number
        tokens.add(Integer.toString(num));


        // Step 2: Process * and /
        List<String> first = new ArrayList<>();

        first.add(tokens.get(0));

        for (int i = 1; i < tokens.size(); i += 2) {

            String operator = tokens.get(i);
            int next = Integer.parseInt(tokens.get(i + 1));

            if (operator.equals("*")) {

                int prev = Integer.parseInt(
                    first.remove(first.size() - 1)
                );

                int val = prev * next;

                first.add(Integer.toString(val));

            } 
            else if (operator.equals("/")) {

                int prev = Integer.parseInt(
                    first.remove(first.size() - 1)
                );

                int val = prev / next;

                first.add(Integer.toString(val));

            } 
            else {

                // Keep + or - for the next step
                first.add(operator);
                first.add(Integer.toString(next));
            }
        }


        // Step 3: Process + and -
        int ans = Integer.parseInt(first.get(0));

        for (int i = 1; i < first.size(); i += 2) {

            String operator = first.get(i);

            int next = Integer.parseInt(first.get(i + 1));

            if (operator.equals("+")) {
                ans = ans + next;
            } 
            else {
                ans = ans - next;
            }
        }

        return ans;
    }
}