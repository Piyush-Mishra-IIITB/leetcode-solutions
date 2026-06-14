class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
       int indegre[]=new int[n];
       for(int i=0;i<n;i++){
           indegre[i]=0;
       }
       for(int i=0;i<edges.size();i++){
         List<Integer>ll=edges.get(i);
          int curr=ll.get(1);
         indegre[curr]+=1;
       }
       List<Integer>ans=new ArrayList<>();
       for(int i=0;i<n;i++){
        if(indegre[i]==0){
            ans.add(i);
        }}
       return ans;
    }
}