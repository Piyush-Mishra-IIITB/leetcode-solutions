class Solution {
    public int reverse(int x) {
        if(x>Integer.MAX_VALUE || x<Integer.MIN_VALUE){
            return 0;
        }
        if(x>0){
            long reverse=0;
            while(x>0){
                reverse=reverse*10+x%10;
                x=x/10;
            }
            return reverse>Integer.MAX_VALUE ? 0:(int)reverse;
        }else{
            long reverse=0;
            int y=Math.abs(x);
            while(y>0){
                reverse=reverse*10+y%10;
                y=y/10;
            }
            return -reverse<Integer.MIN_VALUE ? 0: (int)-reverse;
        }
    }
}