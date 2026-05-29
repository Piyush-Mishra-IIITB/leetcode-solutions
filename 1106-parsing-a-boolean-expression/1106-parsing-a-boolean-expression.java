class Solution {
    public boolean parseBoolExpr(String s) {
        Stack<Character>ss=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==','){
                continue;
            }
            if(c==')'){
                HashSet<Character>hs=new HashSet<>();
                while(ss.peek()!='('){
                    hs.add(ss.pop());
                }
                ss.pop();
                char op=ss.pop();
                ss.push(eval(hs,op));
                continue;
            }
            ss.push(c);
        }
         if(ss.peek()=='t'){
            return true;
        }else{
            return false;
        }
    }
    public char eval(HashSet<Character>hs,char c){
        for(int i=0;i<hs.size();i++){
            if(c=='!'){
                if(hs.contains('f')){
                    return 't';
                }else{
                    return 'f';
                }
            }
            else if(c=='&'){
                if(hs.contains('f')){
                    return 'f';
                }else{
                   return 't';
                }
            }
            else if(c=='|'){
                if(hs.contains('t')){
                    return 't';
                }else{
                   return 'f';
                }
            }
        }
        return 'p';
    }
}