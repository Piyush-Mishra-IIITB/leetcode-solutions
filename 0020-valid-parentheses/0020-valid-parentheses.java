class Solution {
    public boolean isValid(String s) {
        Stack<Character>ss=new Stack<>();
        int length=s.length();
        int i=0;
        int open=0;
        int close=0;
        while(i<length){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c =='['){
                ss.push(c);
                open++;
            }else if(c==')'){
                while(!ss.isEmpty() && ss.peek()!='('){
                    ss.pop();
                }
                if(ss.isEmpty()){
                    return false;
                }
                if(!ss.isEmpty()){
                    ss.pop();}
                    close++;
               
            }else if(c=='}'){
                while(!ss.isEmpty() && ss.peek()!='{'){
                    ss.pop();
                }
                if(ss.isEmpty()){
                    return false;
                }
                if(!ss.isEmpty()){
                    ss.pop();}
                    close++;
            }else if(c==']'){
                while(!ss.isEmpty() && ss.peek()!='['){
                    ss.pop();
                }
                if(ss.isEmpty()){
                    return false;
                }
                if(!ss.isEmpty()){
                    ss.pop();}
                    close++;
            }
            i++;

        }
        if(open==close){
             return ss.isEmpty();
        }
        return false;
}
}