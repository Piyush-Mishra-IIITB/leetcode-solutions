class Solution {
    public int findChampion(int n, int[][] edges) {
        int indegree[]=new int[n];
        for(int i=0;i<edges.length;i++){
            int a[]=edges[i];
            int u=a[0];
            int v=a[1];
            indegree[v]++;
        }
        List<Integer>ll=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                ll.add(i);
            }
        }
        if(ll.size()!=1){
            return -1;
        }
        else{
            return ll.get(0);
        }
    }
}