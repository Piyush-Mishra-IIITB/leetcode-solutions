class Solution {
    public int numSimilarGroups(String[] strs) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                if(helper(strs[i],strs[j])){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean vis[]=new boolean[strs.length];
        int ans=0;
        for(int i=0;i<strs.length;i++){
            if(vis[i]==false){
                dfs(i,vis,adj,-1);
                ans++;
            }
        }
        return ans;
    }
    public void dfs(int i,boolean vis[],List<List<Integer>>adj,int parent){
        vis[i]=true;
        for(Integer it:adj.get(i)){
            if(it==parent){
                continue;
            }
            if(vis[it]==false){
                dfs(it,vis,adj,i);
            }
        }
    }

    public boolean helper(String a,String b){
         int ans=0;
         for(int i=0;i<a.length();i++){
            char c=a.charAt(i);
            char d=b.charAt(i);
            if(c!=d){
                ans++;
            }
         }
         if(ans==0||ans==2){
            return true;
         }
         return false;
    }
}