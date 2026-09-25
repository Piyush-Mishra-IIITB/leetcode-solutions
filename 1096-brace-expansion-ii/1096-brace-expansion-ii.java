import java.util.*;

class Solution {

    Set<String> set = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(set);
    }

    private void dfs(String exp) {

        // Find first '}'
        int j = exp.indexOf('}');

        // No braces left -> complete word
        if (j == -1) {
            set.add(exp);
            return;
        }

        // Find matching '{'
        int i = exp.lastIndexOf('{', j);

        String before = exp.substring(0, i);
        String inside = exp.substring(i + 1, j);
        String after = exp.substring(j + 1);

        // Try every option inside {}
        for (String option : inside.split(",")) {
            dfs(before + option + after);
        }
    }
}