class Solution {
    public List<String> findAllRecipes(String[] recipes,
                                       List<List<String>> ingredients,
                                       String[] supplies) {

        HashMap<String, List<String>> adj = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {

            indegree.put(recipes[i], ingredients.get(i).size());

            for (String ing : ingredients.get(i)) {
                adj.putIfAbsent(ing, new ArrayList<>());
                adj.get(ing).add(recipes[i]);
            }
        }
        Queue<String> q = new LinkedList<>();
        for (String supply : supplies) {
            q.offer(supply);
        }

        List<String> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (!adj.containsKey(curr))
                continue;
            for (String recipe : adj.get(curr)) {
                indegree.put(recipe, indegree.get(recipe) - 1);
                if (indegree.get(recipe) == 0) {
                    ans.add(recipe);
                    q.offer(recipe);
                }
            }
        }

        return ans;
    }
}