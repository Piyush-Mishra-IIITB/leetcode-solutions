class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++) {
                parent[i]=i;
            }
        }

        int find(int x) {
            if(parent[x]==x) return x;
            return parent[x]=find(parent[x]);
        }

        void union(int a,int b) {
            int pa=find(a);
            int pb=find(b);

            if(pa==pb) return;

            if(rank[pa]<rank[pb]) {
                parent[pa]=pb;
            } else if(rank[pb]<rank[pa]) {
                parent[pb]=pa;
            } else {
                parent[pb]=pa;
                rank[pa]++;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DSU dsu=new DSU(n);
        Map<String,Integer> emailToAccount=new HashMap<>();

        for(int i=0;i<n;i++) {
            List<String> account=accounts.get(i);
            for(int j=1;j<account.size();j++) {
                String email=account.get(j);
                if(!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email,i);
                } else {
                    dsu.union(i,emailToAccount.get(email));
                }
            }
        }

        Map<Integer,TreeSet<String>> merged=new HashMap<>();

        for(String email:emailToAccount.keySet()) {
            int accIndex=emailToAccount.get(email);
            int parent=dsu.find(accIndex);
            merged.putIfAbsent(parent,new TreeSet<>());
            merged.get(parent).add(email);
        }

        List<List<String>> ans=new ArrayList<>();

        for(int parent:merged.keySet()) {
            List<String> curr=new ArrayList<>();
            curr.add(accounts.get(parent).get(0));
            curr.addAll(merged.get(parent));
            ans.add(curr);
        }

        return ans;
    }
}