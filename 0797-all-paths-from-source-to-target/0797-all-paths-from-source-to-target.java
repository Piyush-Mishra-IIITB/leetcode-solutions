class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
        boolean vis[]=new boolean[graph.length];
        helper(ll,ans,0,graph,vis);
        return ans;
    }
    public void helper(List<Integer>ll,List<List<Integer>>ans,int val,int graph[][],boolean vis[]){
        if(vis[val]==true){
            return;
        }
        ll.add(val);
        vis[val]=true;
        if(val==graph.length-1){
            vis[val]=false;
            ans.add(new ArrayList<>(ll));
            ll.remove(ll.size()-1);
            return;
        }
        for(Integer it:graph[val]){
            helper(ll,ans,it,graph,vis);
        }
        ll.remove(ll.size()-1);
        vis[val]=false;
    }
}