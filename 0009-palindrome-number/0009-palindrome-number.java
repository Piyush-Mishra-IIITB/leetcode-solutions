class Solution {
    public boolean isPalindrome(int x) {
        int reverse=0;
        int org=x;
        while(org>0){
            reverse=reverse*10+org%10;
            org=org/10;
        }
        return reverse==x;
    }
}