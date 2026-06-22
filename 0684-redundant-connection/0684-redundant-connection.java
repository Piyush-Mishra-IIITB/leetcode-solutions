public class DisjointSet{
    List<Integer>rank=new ArrayList<>();
    List<Integer>parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int upar(int node){
        if(node==parent.get(node)){
            return node;
        }
        parent.set(node,upar(parent.get(node)));
        return parent.get(node);
    }
    public void union(int a,int b){
        int pa=upar(a);
        int pb=upar(b);
        if(pa==pb){
            return;
        }
        else if(rank.get(pa)>rank.get(pb)){
            parent.set(pb,pa);
        }
        else if(rank.get(pa)<rank.get(pb)){
            parent.set(pa,pb);
        }else if(rank.get(pa)==rank.get(pb)){
            parent.set(pa,pb);
            rank.set(pb,rank.get(pb)+1);
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int ans[]=new int[2];
        int n=edges.length;
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<edges.length;i++){
            int a[]=edges[i];
            int u=a[0]-1;
            int v=a[1]-1;
            if(ds.upar(u)!=ds.upar(v)){
                ds.union(u,v);
            }else{
                ans[0]=u+1;
                ans[1]=v+1;
            }
        }
        return ans; 
    }
}