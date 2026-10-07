class Solution {
    public int minAddToMakeValid(String s) {
         Stack<Character>ss=new Stack<>();
        int open=0;
        int close=0;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr=='('){
                open++;
            }else if(curr==')'){
                if(open>0){
                    open--;
                }else{
                   close++;
                }       
            }  
    }
    return open+close;
    }
}