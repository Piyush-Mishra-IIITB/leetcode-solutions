class Solution {
    int max=0;
    public int longestPath(int[] parent, String s) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=parent.length;
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for(int i=1;i<parent.length;i++){
            if(parent[i]!=-1){
                  ans.get(i).add(parent[i]);
                  ans.get(parent[i]).add(i);
            }
        }
        
        dfs(0,ans,s,-1);
         return max;
    }
    public int dfs(int i,List<List<Integer>>ans,String s,int p){
           int longest=0;
           int second_longest=0;
           for(Integer it: ans.get(i)){
             if(it==p){
                continue;
             }
              int a=dfs(it,ans,s,i);
              if(s.charAt(it)==s.charAt(i)){
                continue;
              }
             if(a > longest){
                second_longest = longest;
               longest = a;
              }
             else if(a > second_longest){
             second_longest = a;
               }
           }
          max=Math.max(max,1+longest+second_longest);
          return 1+longest;
    }
}