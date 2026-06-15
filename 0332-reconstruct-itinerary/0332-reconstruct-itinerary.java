class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> hm =new HashMap<>();
        for(int i=0;i<tickets.size();i++){

            String a=tickets.get(i).get(0);
            String b=tickets.get(i).get(1);
            hm.putIfAbsent(a,new PriorityQueue<>());
            hm.get(a).offer(b);
        }
        dfs("JFK",hm);
        Collections.reverse(ans);
        return ans;
    }

    public void dfs(String start,HashMap<String,PriorityQueue<String>> hm){

        while(hm.containsKey(start) &&!hm.get(start).isEmpty()){
            String next=hm.get(start).poll();
            dfs(next,hm);
        }
        ans.add(start);
    }
}