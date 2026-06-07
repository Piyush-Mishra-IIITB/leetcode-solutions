class Solution {
    public class pair{
        String s;
        int val;
        public pair(String s,int val){
            this.s=s;
            this.val=val;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> ll) {
        HashSet<String>hs=new HashSet<>();
        HashMap<String,Boolean>hm=new HashMap<>();
        for(int i=0;i<ll.size();i++){
            hs.add(ll.get(i));
            hm.put(ll.get(i),false);
        }
        hm.put(beginWord,true);
        if(hs.contains(endWord)==false){
            return 0;
        }
        Queue<pair>qq=new LinkedList<>();
        qq.add(new pair(beginWord,1));
        while(!qq.isEmpty()){
            pair p=qq.poll();
            String curr=p.s;
            int steps=p.val;
            if(curr.equals(endWord)){
                return steps;
            }
            for(int i=0;i<ll.size();i++){
                if(helper2(curr,ll.get(i)) && hm.get(ll.get(i))==false){
                    qq.add(new pair(ll.get(i),steps+1));
                    hm.put(ll.get(i),true);
                }
            }
        }
        return 0;
    }
           public boolean helper2(String a,String b){
           
           int i=0;
           int j=0;
           while(i<a.length() && i<b.length()){
              char c=a.charAt(i);
              char d=b.charAt(i);
              if(c!=d){
                 j++;
              }
              i++;
           }
           while(i<a.length()){
             j++;
             i++;
           }
           while(i<b.length()){
            j++;
            i++;
           }
           if(j==1){
            return true;
           }
           else{
            return false;
           }
           }
}