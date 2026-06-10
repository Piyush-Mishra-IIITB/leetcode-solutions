class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int arr[]=edges[i];
            int a=arr[0];
            int b=arr[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        return dfs(adj,0,-1,hasApple);
    }
    public int dfs(List<List<Integer>>adj,int curr,int parent,List<Boolean> hasApple){
        int time=0;
        for(Integer it:adj.get(curr)){
            if(parent==it){
                continue;
            }
            
             int time_from_child=dfs(adj,it,curr,hasApple);
            
            if(time_from_child>0||hasApple.get(it)==true){
                time +=2+time_from_child;
            }
        }
        return time;
    }

}