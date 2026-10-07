class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int todel=helper(s);
        HashSet<String>ll=new HashSet<>();
         StringBuilder sb=new StringBuilder();
         helper(0,todel,ll,sb,s);
         List<String>ans=new ArrayList<>();
         for(String c:ll){
            ans.add(c);
         }
         return ans;
    }
    public void helper(int ind,int todel,HashSet<String>ll,StringBuilder sb,String s){
        
          if(ind==s.length()){
              if(todel==0 && isValid(sb.toString())){
                String ss=sb.toString();
                ll.add(ss);
              }
            return;
          }
          if(s.charAt(ind)!='(' && s.charAt(ind)!=')'){
              sb.append(s.charAt(ind));
              helper(ind+1,todel,ll,sb,s);
              sb.setLength(sb.length()-1);
          }else{
             if (todel > 0) {
             helper(ind + 1, todel - 1, ll, sb, s);
            }

             int length=sb.length();
             sb.append(s.charAt(ind));
             helper(ind+1,todel,ll,sb,s);
             sb.setLength(length);
          }
        

    }
    public boolean isValid(String s){
        Stack<Character>ss=new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr==')'){
                while(!ss.isEmpty() && ss.peek()!='('){
                    ss.pop();
                }
                if(!ss.isEmpty() && ss.peek()=='('){
                    ss.pop();
                }else if(ss.isEmpty()){
                    return false;
                }
                
            }else if(curr=='('){
                ss.push(curr);
            }
        }
        return ss.isEmpty();
    }
    public int helper(String s){
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