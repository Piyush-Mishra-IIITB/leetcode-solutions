class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int n=graph.length;
        int m=graph[0].length;
        
         List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ll=new ArrayList<>();
       helper(ll,ans,graph,n-1,0);
       return ans;
        
    }
    public void helper(List<Integer>ll,List<List<Integer>>ans,int graph[][],int target,int curr_node){
        
        if(curr_node==target){
            ll.add(curr_node);
            ans.add(new ArrayList<>(ll));
            ll.remove(ll.size()-1);
            return;
        }
        ll.add(curr_node);
        for(int it:graph[curr_node]){
            helper(ll,ans,graph,target,it);
        }
        ll.remove(ll.size()-1);
    }
}