class Solution {
    public String reverseParentheses(String s) {
        StringBuilder ans=new StringBuilder();
        Stack<Character>ss=new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr==')'){ 
                StringBuilder cur=new StringBuilder();
                while(!ss.isEmpty()&& ss.peek()!='('){
                    cur.append(ss.pop());
                }
                if(!ss.isEmpty()){
                    ss.pop();
                }
                for(int j=0;j<cur.length();j++){
                    System.out.println(cur.charAt(j));
                    ss.push(cur.charAt(j));
                }
                continue;
            }
            if(curr!=')'){
                ss.push(curr);
            }
            

        }
        while(!ss.isEmpty()){
            ans.append(ss.pop());
        }
        return ans.reverse().toString();
    }
}