class Solution {
    public class pair{
        Character c;
        int no;
        public pair(Character c,int no){
            this.c=c;
            this.no=no;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<pair>ss=new Stack<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            int n=1;
            while(!ss.isEmpty()&& ss.peek().c==curr){
                 n=ss.peek().no+n;
                ss.pop();
            }
            ss.push(new pair(curr,n));
            if(ss.peek().no>=k){
                ss.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!ss.isEmpty()){
              pair p=ss.pop();
              int n=p.no;
              char c=p.c;
              while(n>0){
                sb.append(c);
                n--;
              }
        }
        return sb.reverse().toString();
    }
}