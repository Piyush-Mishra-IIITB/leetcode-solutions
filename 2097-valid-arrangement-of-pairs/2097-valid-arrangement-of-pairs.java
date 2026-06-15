class Solution {

    List<Integer> ans=new ArrayList<>();

    public int[][] validArrangement(int[][] pairs) {

        HashMap<Integer,List<Integer>> hm=new HashMap<>();

        HashMap<Integer,Integer> indeg=new HashMap<>();
        HashMap<Integer,Integer> outdeg=new HashMap<>();

        for(int i=0;i<pairs.length;i++){
            int u=pairs[i][0];
            int v=pairs[i][1];
            hm.putIfAbsent(u,new ArrayList<>());
            hm.get(u).add(v);
            outdeg.put(u,outdeg.getOrDefault(u,0)+1);
            indeg.put(v,indeg.getOrDefault(v,0)+1);
        }
        int start=pairs[0][0];
        for(Integer node:outdeg.keySet()){
            int out=outdeg.getOrDefault(node,0);
            int in=indeg.getOrDefault(node,0);
            if(out-in==1){
                start=node;
                break;
            }
        }
        dfs(start,hm);
        Collections.reverse(ans);
        int res[][]=new int[pairs.length][2];
        for(int i=0;i<pairs.length;i++){
            res[i][0]=ans.get(i);
            res[i][1]=ans.get(i+1);
        }
        return res;
    }

    public void dfs(int start,HashMap<Integer,List<Integer>> hm){

        while(hm.containsKey(start) &&!hm.get(start).isEmpty()){

            int next=hm.get(start).remove( hm.get(start).size()-1);
            dfs(next,hm);
        }
        ans.add(start);
    }
}