class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer>ss=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
             sb.append(s.charAt(i));
        }
        for(int i=0;i<sb.length();i++){
               char c=sb.charAt(i);
               if(c=='('){
                ss.push(i);
               }
               else if(c==')'){
                int a=ss.pop();
                  helper(sb,a,i);
               }
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<sb.length();i++){
            char c=sb.charAt(i);
            if(c!='(' && c!=')'){
                ans.append(c);
            }
        }
        return ans.toString();
    }
    public void helper(StringBuilder sb,int a ,int b){
        while(a<=b){
            char c=sb.charAt(a);
            sb.setCharAt(a, sb.charAt(b));
             sb.setCharAt(b, c);
            a++;
            b--;
        }
    }
}