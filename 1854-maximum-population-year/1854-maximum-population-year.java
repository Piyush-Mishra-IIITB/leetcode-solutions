class Solution {
    public class pair{
        int year;
        int val;
        
        public pair(int year,int val){
            this.year=year;
            this.val=val;   
        }
    }
    public int maximumPopulation(int[][] logs) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<logs.length;i++){
            int a[]=logs[i];
            int u=a[0];
            int v=a[1];
            for(int j=u;j<v;j++){
                if(hm.containsKey(j)){
                   hm.put(j,hm.get(j)+1);
                }else{
                    hm.put(j,1);
                }
            }
        }
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->{
            if(a.val!=b.val){
                return b.val-a.val;
            }
            return a.year-b.year;
        });
        for(Integer it:hm.keySet()){
            pq.add(new pair(it,hm.get(it)));
        }
        return pq.peek().year;
    }
}