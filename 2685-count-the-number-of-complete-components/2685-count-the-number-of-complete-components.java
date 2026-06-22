public class Ds{
    List<Integer>rank=new ArrayList<>();
    List<Integer>parent=new ArrayList<>();
    public Ds(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        } 
    }
    public int findUpar(int n){
        if(n==parent.get(n)){
            return n;
        }
        parent.set(n,findUpar(parent.get(n)));
        return parent.get(n);
    }
    public void union(int a,int b){
        int pa=findUpar(a);
        int pb=findUpar(b);
        if(pa==pb){
            return;
        }
        if(rank.get(pa)<rank.get(pb)){
            parent.set(pa,pb);
        }
        if(rank.get(pa)>rank.get(pb)){
            parent.set(pb,pa);
        }if(rank.get(pa)==rank.get(pb)){
            parent.set(pa,pb);
            rank.set(pb,rank.get(pb)+1);
        }
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Ds ds=new Ds(n);
        for(int i=0;i<edges.length;i++){
            int a[]=edges[i];
            int u=a[0];
            int v=a[1];
            ds.union(u,v);
        }
        List<List<Integer>>an=new ArrayList<>();
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<n;i++){
           if(hs.contains(i)){
                 continue;
           }
           List<Integer>ll=new ArrayList<>();
           ll.add(i);
           for(int j=i+1;j<n;j++){
              if(ds.findUpar(i)==ds.findUpar(j)){
                ll.add(j);
                hs.add(j);
              }
           }
           an.add(new ArrayList<>(ll));
        }
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int a[]=edges[i];
            int u=a[0];
            if(hm.containsKey(u)){
                hm.put(u,hm.get(u)+1);
            }else{
                hm.put(u,1);
            }
        }
        int ans=0;
        for(int i=0;i<an.size();i++){
            List<Integer>ll=an.get(i);
            int count=0;
            for(int j=0;j<ll.size();j++){
                if(hm.containsKey(ll.get(j))){
                    count+=hm.get(ll.get(j));
                }
            }
            int m=ll.size();
            if(m*(m-1)/2==count){
                ans++;
            }
        }
        return ans;
    }
}