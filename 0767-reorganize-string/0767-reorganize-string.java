class Solution {
    public class pair{
        char c;
        int val;
        public pair(char c,int val){
            this.c=c;
            this.val=val;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(hm.containsKey(curr)){
                  hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
        }
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->b.val-a.val);

        for(Character ch:hm.keySet()){
            pq.add(new pair(ch,hm.get(ch)));
            }
            StringBuilder sb=new StringBuilder();
            pair prev=null;
        while(!pq.isEmpty()){
                pair p=pq.poll();
                char c=p.c;
                p.val--;
                sb.append(c);
                
                if(prev!=null && prev.val>0){
                  pq.add(prev);
                }
                prev=p;
             }
        if(prev!=null && prev.val>0){
            return "";
        }
        return sb.toString();
    }
}