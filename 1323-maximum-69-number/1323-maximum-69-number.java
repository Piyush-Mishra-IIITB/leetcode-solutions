class Solution {
    public int maximum69Number (int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            sb.append(n%10);
            n=n/10;
        }
        sb.reverse();
        int val=1;
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<sb.length();i++){
            char c=sb.charAt(i);
            if(c=='6' && val>0){
                sb2.append('9');
                val--;
            }else{
              sb2.append(c);
            }
        }
        return Integer.parseInt(sb2.toString());
    }
}