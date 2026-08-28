class Solution {
    public boolean isValid(String s) {
      Stack<Character>ss=new Stack<>();
      for(int i=0;i<s.length();i++){
        char curr=s.charAt(i);
         if(curr=='(' || curr=='{' || curr=='['){
            ss.push(curr);
         }else if(curr==')'){
             if(!ss.isEmpty() && ss.peek()=='('){
                ss.pop();
             }else{
                return false;
             }
         }else if(curr=='}'){
             if(!ss.isEmpty() && ss.peek()=='{'){
                ss.pop();
             }else{
                return false;
             }
         }else{
            if(!ss.isEmpty() && ss.peek()=='['){
                ss.pop();
             }else{
                return false;
             }
         }
      }
      return ss.isEmpty() ? true:false;
    }
}