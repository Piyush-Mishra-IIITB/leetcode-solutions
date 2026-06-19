class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return Arrays.asList(0);
        }
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[]=new int[n];
        for(int i=0;i<edges.length;i++){
            int a[]=edges[i];
            int u=a[0];
            int v=a[1];
            indegree[u]++;
            indegree[v]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer>qq=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==1){
                qq.add(i);
            }
        }
       while(n>2){
          int size=qq.size();
          n=n-size;
          for(int i=0;i<size;i++){
             int curr=qq.poll();
             for(Integer it:adj.get(curr)){
                indegree[it]--;
                if(indegree[it]==1){
                    qq.add(it);
                }
             }
          }
       }
       List<Integer>ans=new ArrayList<>();
       while(!qq.isEmpty()){
          ans.add(qq.poll());
       }
       return ans;
    }
}