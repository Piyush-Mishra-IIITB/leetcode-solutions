class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();
        List<String>ll=new ArrayList<>();
        helper(n,0,0,ll,sb);
        return ll;
    }
    public void helper(int n,int open,int close,List<String>ll,StringBuilder sb){
        if(sb.length()==2*n){
            String toAdded=sb.toString();
            ll.add(toAdded);
            return;
        }
        if(open<n){
            int init=sb.length();
            sb.append('(');
            helper(n,open+1,close,ll,sb);
            sb.setLength(init);
        }if(open>close){
             int init=sb.length();
            sb.append(')');
            helper(n,open,close+1,ll,sb);
            sb.setLength(init);
        }
    }
}