class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a[]=edges[i];
            int u=a[0];
            int v=a[1];
            adj.get(v).add(u);
        }
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            boolean vis[]=new boolean[n];
            Queue<Integer>qq=new LinkedList<>();
            qq.add(i);
            vis[i]=true;
            List<Integer>ll=new ArrayList<>();
            while(!qq.isEmpty()){
                int curr=qq.poll();
                for(Integer it:adj.get(curr)){
                    if(vis[it]==false){
                        qq.add(it);
                        ll.add(it);
                        vis[it]=true;
                    }  
                }
            }
            Collections.sort(ll);
            ans.add(ll);
        }
        return ans;
    }
}