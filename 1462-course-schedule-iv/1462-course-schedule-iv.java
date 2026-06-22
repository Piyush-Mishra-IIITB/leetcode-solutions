class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int a[]=prerequisites[i];
            int u=a[0];
            int v=a[1];
            adj.get(u).add(v);
        }
        List<Boolean>ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int a[]=queries[i];
            int u=a[0];
            int v=a[1];
            Queue<Integer>qq=new LinkedList<>();
            qq.add(u);
            boolean vis[]=new boolean[n];
            vis[u]=true;
            while(!qq.isEmpty()){
                int curr=qq.poll();
                for(Integer it:adj.get(curr)){
                    if(vis[it]==false){
                        vis[it]=true;
                        qq.add(it);
                    }
                }
            }
            if(vis[v]){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
    
}