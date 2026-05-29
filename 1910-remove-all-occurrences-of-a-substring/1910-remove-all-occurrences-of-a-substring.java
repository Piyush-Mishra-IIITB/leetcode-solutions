class Solution {
    public boolean check(Stack<Character>ss,String part){
        Stack<Character> sss = new Stack<>();
           sss.addAll(ss);
        for(int i=part.length()-1;i>=0;i--){
            if(sss.peek()!=part.charAt(i)){
                return false;
            }
            sss.pop();
        }
        return true;
    }
    public String removeOccurrences(String s, String part) {
    
     Stack<Character>ss=new Stack<>();
     for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        ss.push(c);
        if(ss.size()>=part.length()&& check(ss,part)){
            for(int j=0;j<part.length();j++){
                if(!ss.isEmpty()){
                    ss.pop();}
            }
        }

     }
     StringBuilder sb=new StringBuilder();
     while(!ss.isEmpty()){
        sb.append(ss.pop());
     }
     return sb.reverse().toString();

    }
}