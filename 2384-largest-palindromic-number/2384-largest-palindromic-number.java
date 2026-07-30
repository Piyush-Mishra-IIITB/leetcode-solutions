class Solution {
    public class pair{
        char c;
        int no;
        public pair(char c,int no){
            this.c=c;
            this.no=no;
        }
    }
    public String largestPalindromic(String num) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<num.length();i++){
            char curr=num.charAt(i);
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
        }
        List<pair>ll=new ArrayList<>();
        List<Character>lll=new ArrayList<>();
        for(Character c:hm.keySet()){
             int val=hm.get(c);
             if(val>=2){
                 ll.add(new pair(c,val/2));
             }
             if(val%2!=0){
                 lll.add(c);
             }
        }
        Collections.sort(ll,(b,a)->Character.compare(b.c,a.c));
        Collections.sort(lll);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ll.size();i++){
              int val=ll.get(i).no;
              char c=ll.get(i).c;
              for(int j=0;j<val;j++){
                 sb.append(c);
              }
        }
        StringBuilder sbnew=sb;
        String fir=sb.toString();
        String last=sbnew.reverse().toString();
        for(int i=0;i<sb.length();i++){
            System.out.println(sb.charAt(i));
        }
        if(lll.size()>0){
            String ans=last+lll.get(lll.size()-1)+fir;
            if(ans.charAt(0)=='0'){
                return String.valueOf(lll.get(lll.size()-1));
            }else{
                return ans;
            }
        }else{
            String ans=last+fir;
            if(ans.charAt(0)=='0'){
                return "0";
            }else{
                return ans;
            }
        }
    }
}