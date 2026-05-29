class Solution {
    public int minAddToMakeValid(String s) {

        Stack<Character>ss=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==')'){
                if(!ss.isEmpty()&& ss.peek()=='('){
                    ss.pop();
                    continue;
                }
            }
            ss.push(c);
        }
        
        return ss.size();
    }
}
