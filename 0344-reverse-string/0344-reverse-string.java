class Solution {
    public void reverseString(char[] c) {
        int i=0;
        int j=c.length-1;
        while(i<=j){
            char t=c[i];
            c[i]=c[j];
            c[j]=t;
            i++;
            j--;
        }
    }
}