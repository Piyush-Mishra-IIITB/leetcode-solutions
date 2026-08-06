class Solution {
    public int smallestNumber(int n, int t) {
        if(t==1){
            return n;
        }
        while(true){
                int product=1;
                int x=n;
                while(x>0){
                    int lastdigit=x%10;
                    product=product*lastdigit;
                    x=x/10;
                }
                if(product%t==0){
                    return n;
                }else{
                   product=1;
                   n++;
             }
        }
        
    }
}