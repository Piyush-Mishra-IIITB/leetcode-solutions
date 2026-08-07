class Solution {
    public class pair{
        char c;
        int t;
        public pair(char c,int t){
            this.c=c;
            this.t=t;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer>hm=new HashMap<>();
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->b.t-a.t);
        for(int i=0;i<tasks.length;i++){
            char curr=tasks[i];
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
        }
        for(Character ch:hm.keySet()){
            pq.add(new pair(ch,hm.get(ch)));
        }
        int ans=0;
        while(!pq.isEmpty()){
            Queue<pair>qq=new LinkedList<>();
            for(int i=0;i<=n;i++){
                if(pq.isEmpty()==false){
                    pair p=pq.poll();
                    int d=p.t;
                    char c=p.c;
                    if(d>1){
                       qq.add(new pair(c,d-1));
                    }
                }
                if(!pq.isEmpty() || !qq.isEmpty()){
                    ans++;}
            }
            while(!qq.isEmpty()){
                pq.add(qq.poll());
            }
        }
       return ans+1;
    }
}