class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        List<List<Integer>>ll=new ArrayList<>();
        for(int i=0;i<n;i++){
            ll.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int a=leftChild[i];
            int b=rightChild[i];
            if(a!=-1 ){
                ll.get(i).add(a);
            }
            if(b!=-1 ){
                ll.get(i).add(b);
            }
        }

       HashMap<Integer,Integer>hm=new HashMap<>();
       for(int i=0;i<n;i++){
            int a=leftChild[i];
            int b=rightChild[i];
            if(a!=-1 ){
                if(hm.containsKey(a)){
                    return false;
                }
                hm.put(a,i);
            }
            if(b!=-1 ){
                if(hm.containsKey(b)){
                    return false;
                }

                hm.put(b,i);
            }
        }
       int indegree[]=new int[n];
       for(int i=0;i<n;i++){
            int a=leftChild[i];
            int b=rightChild[i];
            if(a!=-1){
                indegree[a]++;
            }
            if(b!=-1){
                indegree[b]++;
            }
       }
       int count=0;
       int start=-1;
       for(int i=0;i<indegree.length;i++){
           if(indegree[i]==0){
            start=i;
            count++;
           }
       }
       if(count!=1){
        return false;
       }
       if(start==-1){
        return false;
       }
        boolean vis2[]=new boolean[n];
        if(!dfs(start,vis2,ll)){
            return false;
        }else{
            for(int i=0;i<vis2.length;i++){
                if(vis2[i]==false){
                    return false;
                }
            }
            return true;
        }

    }
    public boolean dfs(int i,boolean vis[],List<List<Integer>>ll){
        vis[i]=true;
        for(Integer it:ll.get(i)){
            if(vis[it]==true){
               return false;
              }
                if(!dfs(it,vis,ll)){
                    return false;
                }
            }
             return true;
        }  
    }
     
