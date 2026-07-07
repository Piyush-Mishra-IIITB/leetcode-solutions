class Solution {
    public long sumAndMultiply(int n) {
        if(n==0){
            return 0;
        }
        long sum=0;
        StringBuilder sb=new StringBuilder();
        while(n>0){
            long last=n%10;
            n=n/10;
            if(last!=0){
                sum+=last;
                sb.append(last);
            }
        }
        long no=Long.parseLong(sb.reverse().toString());
        System.out.println(no);
        return no*sum;
       
    }
}