class Solution {
    public boolean isHappy(int n) {
     HashSet<Integer>hs=new HashSet<>();
     while(n!=1 && hs.contains(n)==false){
        hs.add(n);
        int sum=0;
        while(n>0){
            int a=n%10;
            sum+=a*a;
            n=n/10;
        }
        n=sum;
     }
     return n==1;   
    }
}