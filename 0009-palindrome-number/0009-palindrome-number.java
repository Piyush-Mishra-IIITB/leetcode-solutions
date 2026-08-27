class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        StringBuilder sb=new StringBuilder();
        while(x>0){
            System.out.println(x);
            sb.append(x%10);
            x=x/10;
        }
        return helper(0,sb.length()-1,sb.toString());
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