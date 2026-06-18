class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for(int i = 0; i < routes.length; i++) {
            int[] a = routes[i];
            for(int j = 0; j < a.length; j++) {
                hm.putIfAbsent(a[j], new ArrayList<>());
                hm.get(a[j]).add(i);
            }
        }
        Queue<Integer> qq = new LinkedList<>();
        HashSet<Integer> stopsVis = new HashSet<>();
        boolean[] vis = new boolean[routes.length];
        qq.add(source);
        stopsVis.add(source);
        int buses = 0;
        while(!qq.isEmpty()) {
            int size = qq.size();
            buses++;
            for(int k = 0; k < size; k++) {
                int s = qq.poll();
                List<Integer> ind = hm.getOrDefault(s, new ArrayList<>());
                for(int bus : ind) {
                    if(vis[bus]) continue;
                    vis[bus] = true;
                    for(int stop : routes[bus]) {
                        if(stop == target)
                            return buses;
                        if(!stopsVis.contains(stop)) {
                            stopsVis.add(stop);
                            qq.add(stop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}