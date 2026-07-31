class Solution {
    public class pair{
        char c;
        int no;
        public pair(char c,int no){
            this.c=c;
            this.no=no;
        }
    }
    public int minimumPushes(String word) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
        }
        List<pair>ll=new ArrayList<>();
        for(Character ch:hm.keySet()){
            ll.add(new pair(ch,hm.get(ch)));
        }
        Collections.sort(ll,(b,a)->a.no-b.no);
        for(int i=0;i<ll.size();i++){
         System.out.println(ll.get(i).c + "->" + ll.get(i).no);
        }
        int ans=0;
        for(int i=0;i<ll.size();i++){
            if(i<8){
               ans+=ll.get(i).no;
            }else if(i>=8 && i<16){
                ans+=ll.get(i).no*2;
            }else if(i>=16 && i<24){
                ans+=ll.get(i).no*3;
            }else{
                ans+=ll.get(i).no*4;
            }
        }
        return ans;
    }
}