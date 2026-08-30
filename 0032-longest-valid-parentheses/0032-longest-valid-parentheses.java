class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer>ss=new Stack<>();
        int ans=0;
        ss.push(-1);
        for(int i=0;i<s.length();i++){
           char curr=s.charAt(i);

           if(curr=='('){
               ss.push(i);
           }else{
               if(ss.isEmpty()==false){
                 ss.pop();
               }
              if(ss.isEmpty()){
                ss.push(i);
              }else{
                ans=Math.max(ans,i-ss.peek());
              }
           }
        }
        return ans;
    }
}