class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>s=new ArrayList<>();
        String ss="";
        helper(ss,s,n,0,0);
        List<String>ans=new ArrayList<>();
        for(int i=0;i<s.size();i++){
            if(verify(s.get(i))){
                ans.add(s.get(i));
            }
        }
        return ans;
        
        }
        public boolean verify(String s){



        Stack<Character>cc=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                cc.push(c);
            }else{
                if(cc.isEmpty()){
                    return false;
                }
                else{
                    cc.pop();
                }
            }
        }
        return cc.isEmpty();
        }
   public void helper(String ss,List<String>s,int n,int open,int close){
    if(ss.length()==2*n){
        s.add(ss);
        return;
    }
    if(open<n){
     helper(ss+'(',s,n,open+1,close);
    }
    if(close<n){
     helper(ss+')',s,n,open,close+1);
    }
   
   }
}