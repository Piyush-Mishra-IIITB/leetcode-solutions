class Solution {
    public String winningPlayer(int x, int y) {
        int count=0;
        int a=y/4;
        int val=Math.min(a,x);
        if(val%2==0){
            return "Bob";
        }else{
            return "Alice";
        }
    }
}