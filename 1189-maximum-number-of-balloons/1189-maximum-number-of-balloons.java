class Solution {
    public int maxNumberOfBalloons(String text) {
        int B=0;
        int A=0;
        int L=0;
        int O=0;
        int N=0;
        for(int i=0;i<text.length();i++){
              char c=text.charAt(i);
              if(c=='b'){
                B++; 
              }else if(c=='a'){
                A++;
              }else if(c=='l'){
                L++;
              }else if(c=='o'){
                O++;
              }else if(c=='n'){
                N++;
              }
        }
        L=L/2;
        O=O/2;
        int x=Math.min(B,A);
        int y=Math.min(L,O);
        int z=Math.min(y,N);
        return Math.min(x,z);

    }
}