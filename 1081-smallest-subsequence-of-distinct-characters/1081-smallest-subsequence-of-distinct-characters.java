class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)+1);
            }else{
                hm.put(c,1);
            }
        }
        HashSet<Character>hs=new HashSet<>();
        Stack<Character>ss=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
              if(hs.contains(c)){
                int val=hm.get(c)-1;
                hm.remove(c);
                hm.put(c,val);
                continue;
               }
             while(!ss.isEmpty() && ss.peek()>c && hm.get(ss.peek())>1){
                int val=hm.get(ss.peek());
                hm.remove(ss.peek());
                hm.put(ss.peek(),val-1);
                hs.remove(ss.peek());
                ss.pop();
             }
            ss.push(c);
            hs.add(c);
        }
        StringBuilder sb=new StringBuilder();
        while(!ss.isEmpty()){
            sb.append(ss.pop());
        }
        return sb.reverse().toString();
    }
}