class Solution {
    public int minimumDeletions(String s) {
        Stack<Character>ss=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='a'){
                if(!ss.isEmpty()&& ss.peek()=='b'){
                    ss.pop();
                    count++;
                    continue;
                }
            }
            ss.push(c);
        }
        return count;
    }
}