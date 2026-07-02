class Solution {
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                boolean first=helper(i+1,j,s);
                boolean second=helper(i,j-1,s);
                return first || second;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    public boolean helper(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}