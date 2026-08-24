class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            hm.put(curr,i);
        }

        Stack<Character>ss=new Stack<>();
        HashSet<Character>hs=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
             if(hs.contains(curr)){
                continue;
            }
            while(!ss.isEmpty() && curr<ss.peek() && hm.get(ss.peek())>i){
                char c=ss.peek();
                if(hs.contains(c)){
                    hs.remove(c);
                }
                ss.pop();
            }
            hs.add(curr);
            ss.push(curr);
        }
        StringBuilder sb=new StringBuilder();
        while(!ss.isEmpty()){
            sb.append(ss.pop());
        }
        return sb.reverse().toString();
    }
}