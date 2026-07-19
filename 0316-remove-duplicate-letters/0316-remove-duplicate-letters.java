class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        Stack<Character>ss=new Stack<>();
        HashSet<Character>hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(hm.containsKey(c)){
                hm.put(c,hm.get(c)+1);
            }else{
                hm.put(c,1);
            }
        }
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
            hs.add(c);
            ss.push(c);
        }
        StringBuilder sb=new StringBuilder();
        while(!ss.isEmpty()){
            sb.append(ss.pop());
        }
        return sb.reverse().toString();
    }
}