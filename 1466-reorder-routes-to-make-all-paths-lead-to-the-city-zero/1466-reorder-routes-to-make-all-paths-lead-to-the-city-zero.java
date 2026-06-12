class Solution {
    int ans=0;
    public int minReorder(int n, int[][] conn) {
        List<List<int []>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<conn.length;i++){
            int a[]=conn[i];
            adj.get(a[0]).add(new int[]{a[1],1});
            adj.get(a[1]).add(new int[]{a[0],0});
        }
        boolean vis[]=new boolean[n];
        helper(0,adj,vis);
        return ans;
    }
    public void helper(int i,List<List<int []>>adj,boolean vis[]){
        vis[i]=true;
        for(int []it:adj.get(i)){
             int a=it[0];
             int b=it[1];
             if(vis[a]==false){
                if(b==1){
                    ans+=1;
                }
                helper(a,adj,vis);
             }
        }
    }
}